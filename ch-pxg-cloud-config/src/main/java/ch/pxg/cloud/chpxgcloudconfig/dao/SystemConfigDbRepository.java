package ch.pxg.cloud.chpxgcloudconfig.dao;

import ch.pxg.cloud.chpxgcloudconfig.model.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 * 2020/3/1  18:37
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/1
 * @Version 1.0.0
 * @description </p>
 */
public interface SystemConfigDbRepository extends
        JpaRepository<SystemConfig,Integer> {
    SystemConfig getByServerNameAndProfileAndLabel(String serverName, String profile, String label);

}
