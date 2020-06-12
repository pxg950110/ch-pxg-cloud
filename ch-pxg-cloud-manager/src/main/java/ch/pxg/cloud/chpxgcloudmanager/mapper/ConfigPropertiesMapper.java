package ch.pxg.cloud.chpxgcloudmanager.mapper;

import ch.pxg.cloud.chpxgcloudmanager.model.ConfigProperties;

public interface ConfigPropertiesMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigProperties record);

    int insertSelective(ConfigProperties record);

    ConfigProperties selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigProperties record);

    int updateByPrimaryKey(ConfigProperties record);
}