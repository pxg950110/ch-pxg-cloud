package ch.pxg.cloud.chpxgcloudauthorserver.mapper;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}