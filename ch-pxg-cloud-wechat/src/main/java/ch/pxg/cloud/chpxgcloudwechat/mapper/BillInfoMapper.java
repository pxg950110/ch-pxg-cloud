package ch.pxg.cloud.chpxgcloudwechat.mapper;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillRequestModel;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillTypeAmount;

import java.util.List;

public interface BillInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillInfo record);

    /**
     * 通过年月日查询相关数据
     * @param record
     * @return
     */
    List<BillInfo> selectByBillInfo(BillInfo record);

    //billDateType year month day  年  月  日
    List<BillTypeAmount>  selectByBillRequestModel(BillRequestModel requestModel);

    List<String>  selectchildDateByBillRequestModel(BillRequestModel requestModel);

    int insertSelective(BillInfo record);

    BillInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillInfo record);

    int updateByPrimaryKey(BillInfo record);
}