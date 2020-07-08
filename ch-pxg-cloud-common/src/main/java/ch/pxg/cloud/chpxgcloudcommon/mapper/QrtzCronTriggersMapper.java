package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzCronTriggers;

public interface QrtzCronTriggersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzCronTriggers record);

    int insertSelective(QrtzCronTriggers record);

    QrtzCronTriggers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzCronTriggers record);

    int updateByPrimaryKey(QrtzCronTriggers record);
}