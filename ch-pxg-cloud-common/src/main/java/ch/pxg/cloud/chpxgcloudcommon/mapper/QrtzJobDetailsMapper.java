package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzJobDetails;

public interface QrtzJobDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzJobDetails record);

    int insertSelective(QrtzJobDetails record);

    QrtzJobDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzJobDetails record);

    int updateByPrimaryKey(QrtzJobDetails record);
}