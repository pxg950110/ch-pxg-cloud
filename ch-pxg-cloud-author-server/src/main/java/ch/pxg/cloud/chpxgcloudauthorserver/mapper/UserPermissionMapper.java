package ch.pxg.cloud.chpxgcloudauthorserver.mapper;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserPermission;

public interface UserPermissionMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}