package ch.pxg.cloud.chpxgcloudauthorserver.dao;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

//JpaSpecificationExecutor
public interface UserInfoJpa  extends
        JpaRepository<UserInfo,Integer> {

    UserInfo getByUserName(String userName);
}
