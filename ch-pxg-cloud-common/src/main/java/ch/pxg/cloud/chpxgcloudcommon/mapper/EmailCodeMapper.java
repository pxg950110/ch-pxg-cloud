package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.EmailCode;

import java.util.List;

public interface EmailCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmailCode record);

    int insertSelective(EmailCode record);

    EmailCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmailCode record);

    int updateByPrimaryKey(EmailCode record);

    int  updateStatusbyPrimary(Integer id);
    List<EmailCode> selectByEmailUrl(String emailUrl);

    EmailCode selectByMsgId(String msgId);

    //最大查询500条
    List<EmailCode> selectSelective(EmailCode emailCode);


}