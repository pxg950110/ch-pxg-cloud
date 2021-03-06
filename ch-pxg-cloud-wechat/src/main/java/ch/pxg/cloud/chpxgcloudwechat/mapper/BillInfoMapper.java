package ch.pxg.cloud.chpxgcloudwechat.mapper;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillRequestModel;
import ch.pxg.cloud.chpxgcloudwechat.modelutil.util.BillTypeAmount;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillInfoMapper {
    /**
     * 删除只做状态的更新
     * @param id
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer id,@Param("userId") String userId);

    int insert(BillInfo record);

    /**
     * 获取最大的年月
     * @return
     */
   String getMaxBillDateInfo(@Param("userId") String userId);
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

    BillInfo selectByPrimaryKey(Integer id,@Param("userId") String userId);

    int updateByPrimaryKeySelective(BillInfo record);

    int updateByPrimaryKey(BillInfo record);
}