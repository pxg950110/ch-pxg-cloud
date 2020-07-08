package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzTriggers;

public interface QrtzTriggersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzTriggers record);

    int insertSelective(QrtzTriggers record);

    QrtzTriggers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzTriggers record);

    int updateByPrimaryKey(QrtzTriggers record);
}