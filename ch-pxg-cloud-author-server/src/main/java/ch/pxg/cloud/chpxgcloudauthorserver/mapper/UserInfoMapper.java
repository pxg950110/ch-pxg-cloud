package ch.pxg.cloud.chpxgcloudauthorserver.mapper;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    List<UserInfo> selectBySelective(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}