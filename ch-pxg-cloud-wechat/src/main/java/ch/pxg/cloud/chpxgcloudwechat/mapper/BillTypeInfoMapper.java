package ch.pxg.cloud.chpxgcloudwechat.mapper;

import ch.pxg.cloud.chpxgcloudwechat.model.BillTypeInfo;

public interface BillTypeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillTypeInfo record);

    int insertSelective(BillTypeInfo record);

    BillTypeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillTypeInfo record);

    int updateByPrimaryKey(BillTypeInfo record);
}