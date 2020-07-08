package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzLocks;

public interface QrtzLocksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzLocks record);

    int insertSelective(QrtzLocks record);

    QrtzLocks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzLocks record);

    int updateByPrimaryKey(QrtzLocks record);
}