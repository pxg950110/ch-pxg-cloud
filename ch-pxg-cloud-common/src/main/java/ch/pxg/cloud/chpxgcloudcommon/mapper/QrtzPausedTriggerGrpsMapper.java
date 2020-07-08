package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzPausedTriggerGrps;

public interface QrtzPausedTriggerGrpsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzPausedTriggerGrps record);

    int insertSelective(QrtzPausedTriggerGrps record);

    QrtzPausedTriggerGrps selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzPausedTriggerGrps record);

    int updateByPrimaryKey(QrtzPausedTriggerGrps record);
}