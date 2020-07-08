package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzFiredTriggers;

public interface QrtzFiredTriggersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzFiredTriggers record);

    int insertSelective(QrtzFiredTriggers record);

    QrtzFiredTriggers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzFiredTriggers record);

    int updateByPrimaryKey(QrtzFiredTriggers record);
}