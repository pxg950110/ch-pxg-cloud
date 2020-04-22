package ch.pxg.cloud.produce.chpxgcloudproduce.util;

import ch.pxg.cloud.produce.chpxgcloudproduce.model.TbGushi;
import ch.pxg.cloud.produce.chpxgcloudproduce.model.TbGushiUrl;

import java.util.List;

/**
 * <p>
 * 2020/3/22  13:32
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
public class GushiResponseVI {
    private TbGushi tbGushi;
    private List<TbGushiUrl> tbGushiUrls;

    public GushiResponseVI() {
    }

    public GushiResponseVI(TbGushi tbGushi, List<TbGushiUrl> tbGushiUrls) {
        this.tbGushi = tbGushi;
        this.tbGushiUrls = tbGushiUrls;
    }

    public TbGushi getTbGushi() {
        return tbGushi;
    }

    public void setTbGushi(TbGushi tbGushi) {
        this.tbGushi = tbGushi;
    }

    public List<TbGushiUrl> getTbGushiUrls() {
        return tbGushiUrls;
    }

    public void setTbGushiUrls(List<TbGushiUrl> tbGushiUrls) {
        this.tbGushiUrls = tbGushiUrls;
    }
}
