package ch.pxg.cloud.chpxgcloudcommon.mapper;

import ch.pxg.cloud.chpxgcloudcommon.model.taskcenter.QrtzCalendars;

public interface QrtzCalendarsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrtzCalendars record);

    int insertSelective(QrtzCalendars record);

    QrtzCalendars selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrtzCalendars record);

    int updateByPrimaryKey(QrtzCalendars record);
}