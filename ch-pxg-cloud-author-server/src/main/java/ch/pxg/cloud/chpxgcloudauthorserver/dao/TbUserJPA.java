package ch.pxg.cloud.chpxgcloudauthorserver.dao;

import ch.pxg.cloud.chpxgcloudauthorserver.model.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbUserJPA extends JpaRepository<TbUser,Integer> {

}
