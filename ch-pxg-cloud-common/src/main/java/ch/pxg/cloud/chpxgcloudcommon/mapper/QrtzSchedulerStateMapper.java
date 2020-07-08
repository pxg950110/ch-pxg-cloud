package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzSchedulerState;

public interface QrtzSchedulerStateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzSchedulerState record);

    int insertSelective(QrtzSchedulerState record);

    QrtzSchedulerState selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzSchedulerState record);

    int updateByPrimaryKey(QrtzSchedulerState record);
}