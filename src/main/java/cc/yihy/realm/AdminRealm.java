package cc.yihy.realm;

import cc.yihy.domain.User;
import cc.yihy.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z9475 on 2016/8/7.
 */
public class AdminRealm extends AuthorizingRealm {
    private UserService userService;
private final static Logger log = LoggerFactory.getLogger(AdminRealm.class);
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> roles=new ArrayList<String>();
        roles.add("admin");
        simpleAuthorizationInfo.addRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
      String userCode= (String) token.getPrincipal();
        log.debug("AdminRealm登陆");
       User user= userService.AdminLogin(userCode);
     if(user==null){
         return  null;
     }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user,user.getPassword().toCharArray(),getName());
        return simpleAuthenticationInfo;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
