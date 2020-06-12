package ch.pxg.cloud.chpxgcloudmanager.mapper;

import ch.pxg.cloud.chpxgcloudmanager.model.SystemConfig;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    /**
     * 获取所有服务
     * @return
     */
    List<SystemConfig> selectAll();
    SystemConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);
}