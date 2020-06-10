package ch.pxg.cloud.chpxgcloudwechat.mapper;

import ch.pxg.cloud.chpxgcloudwechat.model.WxUserLog;

public interface WxUserLogMapper {

    int insert(WxUserLog record);

    int insertSelective(WxUserLog record);

    WxUserLog selectByPrimaryKey(Long id);

}