package ch.pxg.cloud.chpxgcloudcommon.dao;

import ch.pxg.cloud.chpxgcloudcommon.model.EmailCode;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailCodeJpa extends JpaRepository<EmailCode ,Integer> {

    EmailCode findAllByMsgId(String msgId);
}
