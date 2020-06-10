package ch.pxg.cloud.chpxgcloudwechat.mapper;

import ch.pxg.cloud.chpxgcloudwechat.model.WxUser;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}