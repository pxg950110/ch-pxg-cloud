package ch.pxg.cloud.chpxgcloudwechat.dao;

import ch.pxg.cloud.chpxgcloudwechat.modelutil.BillTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BillTypeInfoJPA extends JpaRepository<BillTypeInfo,Integer> {

    List<BillTypeInfo> findAllByUserIdIn(Collection<String> userId);
}
