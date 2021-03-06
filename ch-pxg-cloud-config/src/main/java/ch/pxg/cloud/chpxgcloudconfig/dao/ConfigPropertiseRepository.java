package ch.pxg.cloud.chpxgcloudconfig.dao;

import ch.pxg.cloud.chpxgcloudconfig.model.ConfigProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 * 2020/3/1  23:06
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
public interface ConfigPropertiseRepository
extends JpaRepository<ConfigProperties,Integer> {
    //    id为0时表示为公共配置
    List<ConfigProperties> getAllByServerIdOrServerId(long serverId, long serverId2);
    List<ConfigProperties> getAllByIsDeletedAndServerIdOrServerId(Integer isDeleted, long serverId, long serverId2);
}
