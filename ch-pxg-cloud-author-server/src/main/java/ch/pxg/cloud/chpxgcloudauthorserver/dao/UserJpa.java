package ch.pxg.cloud.chpxgcloudauthorserver.dao;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJpa extends JpaRepository<UserInfo,Integer> {
}
