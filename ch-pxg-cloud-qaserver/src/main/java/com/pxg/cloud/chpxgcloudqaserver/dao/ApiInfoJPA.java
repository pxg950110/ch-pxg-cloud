package com.pxg.cloud.chpxgcloudqaserver.dao;

import com.pxg.cloud.chpxgcloudqaserver.model.ApiInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiInfoJPA extends JpaRepository<ApiInfo, Long> {
    List<ApiInfo> findByUrlPathAndStatus(String urlPath, long status);
}
