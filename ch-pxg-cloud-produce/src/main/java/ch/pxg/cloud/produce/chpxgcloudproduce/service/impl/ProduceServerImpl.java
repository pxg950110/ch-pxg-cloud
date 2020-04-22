package ch.pxg.cloud.produce.chpxgcloudproduce.service.impl;

import ch.pxg.cloud.produce.chpxgcloudproduce.dao.TbGushiContentJpa;
import ch.pxg.cloud.produce.chpxgcloudproduce.dao.TbGushiJPA;
import ch.pxg.cloud.produce.chpxgcloudproduce.feignclient.PythonFeignClinet;
import ch.pxg.cloud.produce.chpxgcloudproduce.model.TbGushi;
import ch.pxg.cloud.produce.chpxgcloudproduce.model.TbGushiUrl;
import ch.pxg.cloud.produce.chpxgcloudproduce.service.ProduceServer;
import ch.pxg.cloud.produce.chpxgcloudproduce.util.GushiResponseVI;
import ch.pxg.cloud.produce.chpxgcloudproduce.util.ResultInfo;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 2020/3/22  12:24
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/22
 * @Version 1.0.0
 * @description </p>
 */
@Service
public class ProduceServerImpl implements ProduceServer {

    private final Logger log = LoggerFactory.getLogger(ProduceServerImpl.class);
    @Autowired
    private TbGushiJPA tbGushiJPA;

    @Autowired
    private TbGushiContentJpa tbGushiContentJpa;

    @Autowired
    private PythonFeignClinet pythonFeignClinet;

    @Value("${produce.python.default.url}")
    private String defaultUrl;

    //开启事务模式
    @Transactional
    @Override
    public ResultInfo getContentByUrl(String url) {
        // 查询url是否存在
        if (StringUtils.isEmpty(url))
            url = defaultUrl;
        // 查询故事页面列表中是否有这个url status=0代表有效
        TbGushi tbGushi = tbGushiJPA.getByGsUrlAndStatus(url, 0);
        if (tbGushi == null) {
            log.info("这个列表在数据库中不存在，调用爬虫接口");
            log.info(url);
            Map<Object, Object> resultMap = (Map<Object, Object>) pythonFeignClinet.getGushiList(url);
            log.info(JSON.toJSONString(resultMap));
//            resultMap.get("next_path");
            TbGushi tbGushi1 = new TbGushi(
                    url,
                    0,
                    new Date(),
                    (String) resultMap.get("next_path")
            );
            //保存到表中
            tbGushiJPA.save(tbGushi1);
            log.info(tbGushi1.toString());
            //故事列表
            List<Map<Object, Object>> mapList = (List<Map<Object, Object>>) resultMap.get("result_list");
           log.info(JSON.toJSONString(mapList));
            // 解析
            //循环
            List<TbGushiUrl> tbGushiUrls=new ArrayList<>();
            mapList.forEach(element->{
                TbGushiUrl tbGushiUrl=new TbGushiUrl();
                //标题和内容 上级id
                tbGushiUrl.setGsParentId(tbGushi1.getId());
                tbGushiUrl.setGsTitle((String) element.get("title"));
                tbGushiUrl.setGsPath((String) element.get("path"));
                tbGushiUrl.setCreateTime(new Date());
                tbGushiUrl.setStatus(0);
                //如果数据已经存在   pass
                if (tbGushiContentJpa.getByGsTitleAndStatus(tbGushiUrl.getGsTitle(),0).size()>0)
                {
                    log.info("数据已存在");
                    //跳出本次循环
                    return;
                }
                //获取内容
                try {
                    Map<Object,Object> map= (Map<Object, Object>) pythonFeignClinet.getGushiContent(tbGushiUrl.getGsPath());
                    log.info(JSON.toJSONString(map));
                    tbGushiUrl.setGsContent((String) map.get("data"));
                }catch (Exception e){
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
                tbGushiUrls.add(tbGushiUrl);
            });

            //批量插入
            tbGushiContentJpa.saveAll(tbGushiUrls);
            //
            log.info("接口调用完成---ok---");
            return ResultInfo.ok(new GushiResponseVI(tbGushi1,tbGushiUrls));
        } else {
            //判断内容中是否有效
            //通过
            return ResultInfo.ok(new GushiResponseVI(
                    tbGushi,
                    tbGushiContentJpa.getAllByGsParentIdAndStatus(
                            tbGushi.getId(),
                            0
                    )
            ));
        }
    }
    @Override
    public void exec() {
        List<TbGushiUrl> tbGushiUrls= tbGushiContentJpa.getAllByGsContentIsNullOrGsContent("");
        log.info(tbGushiUrls.toString());
        tbGushiUrls.forEach(
                tbGushiUrl -> {
                    try {
                        Map<Object,Object> map= (Map<Object, Object>) pythonFeignClinet.getGushiContent(tbGushiUrl.getGsPath());
                        log.info(JSON.toJSONString(map));
                        tbGushiUrl.setGsContent((String) map.get("data"));
                        tbGushiContentJpa.saveAndFlush(tbGushiUrl);
//                        log.info(JSON.toJSONString);
                    }catch (Exception e){
                        e.printStackTrace();
                        log.error(e.getMessage());
                    }

                }

        );
    }
}
