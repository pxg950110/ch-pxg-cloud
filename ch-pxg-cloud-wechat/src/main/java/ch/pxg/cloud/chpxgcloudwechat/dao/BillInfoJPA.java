package ch.pxg.cloud.chpxgcloudwechat.dao;

import ch.pxg.cloud.chpxgcloudwechat.model.BillInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 所有的业务入口必须绑定 userid 即openId
 */
public interface BillInfoJPA extends JpaRepository<BillInfo,Integer> {

    List<BillInfo> findAllByUserIdAndStatus(String userId, long status);
}
