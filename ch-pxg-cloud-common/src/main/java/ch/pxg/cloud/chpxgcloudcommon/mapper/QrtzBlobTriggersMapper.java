package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzBlobTriggers;

public interface QrtzBlobTriggersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzBlobTriggers record);

    int insertSelective(QrtzBlobTriggers record);

    QrtzBlobTriggers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzBlobTriggers record);

    int updateByPrimaryKey(QrtzBlobTriggers record);
}