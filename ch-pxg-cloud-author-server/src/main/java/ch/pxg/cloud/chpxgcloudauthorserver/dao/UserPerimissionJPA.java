package ch.pxg.cloud.chpxgcloudauthorserver.dao;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 2020/3/15  16:39
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/3/15
 * @Version 1.0.0
 * @description </p>
 */
public interface UserPerimissionJPA extends JpaRepository<UserPermission ,Integer> {
}
