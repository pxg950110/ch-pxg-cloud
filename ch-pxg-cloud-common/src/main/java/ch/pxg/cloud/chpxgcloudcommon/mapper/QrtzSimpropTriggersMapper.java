package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzSimpropTriggers;

public interface QrtzSimpropTriggersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzSimpropTriggers record);

    int insertSelective(QrtzSimpropTriggers record);

    QrtzSimpropTriggers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzSimpropTriggers record);

    int updateByPrimaryKey(QrtzSimpropTriggers record);
}