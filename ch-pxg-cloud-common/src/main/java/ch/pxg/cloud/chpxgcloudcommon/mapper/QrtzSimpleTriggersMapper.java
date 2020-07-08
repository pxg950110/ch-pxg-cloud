package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzSimpleTriggers;

public interface QrtzSimpleTriggersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzSimpleTriggers record);

    int insertSelective(QrtzSimpleTriggers record);

    QrtzSimpleTriggers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzSimpleTriggers record);

    int updateByPrimaryKey(QrtzSimpleTriggers record);
}