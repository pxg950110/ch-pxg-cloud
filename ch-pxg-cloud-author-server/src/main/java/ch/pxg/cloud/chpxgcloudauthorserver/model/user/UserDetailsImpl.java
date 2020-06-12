package ch.pxg.cloud.chpxgcloudauthorserver.model.user;

import ch.pxg.cloud.chpxgcloudauthorserver.model.UserInfo;
import ch.pxg.cloud.chpxgcloudauthorserver.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 2020/6/11  23:35
 * </p>
 * <p>
 * @author pxg
 * @emil pxg950110@163.com
 * @Date 2020/6/11
 * @Version 1.0.0
 * @description </p>
 */
public class UserDetailsImpl implements UserDetails {


    private static final long serialVersionUID = 5091926422252679850L;
    private Integer userId;
    private String username;
    private String password;
    private Date createTime;
    private Integer status;
    private List<UserRole> roleList;


    public UserDetailsImpl() {
    }

    public UserDetailsImpl(UserInfo userInfo) {
        this.userId=userInfo.getId();
        this.username=userInfo.getUserName();
        this.password=userInfo.getUserPassword();
        this.createTime=userInfo.getCreateTime();
        this.status=userInfo.getStatus();
        this.roleList=userInfo.getRoleList();
    }

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Returns the password used to authenticate the user.
     * @return the password
     */
    @Override
    public String getPassword() {
        return null;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return null;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}
