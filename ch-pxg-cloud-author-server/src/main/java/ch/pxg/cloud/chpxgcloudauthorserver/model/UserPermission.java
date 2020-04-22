package ch.pxg.cloud.chpxgcloudauthorserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appuser.user_permission")
public class UserPermission {

  @Id
  @Column(name = "user_id")
  private long userId;
  @Column(name = "role_id")
  private long roleId;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "UserPermission{" +
            "userId=" + userId +
            ", roleId=" + roleId +
            '}';
  }
}
