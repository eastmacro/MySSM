package shiro;

import domain.User;
import manage.service.LoginService;
import manage.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author xiong
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private LoginService loginService;

    @Autowired
    private RoleService roleService;

    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        int userId = Integer.parseInt(principalCollection.getPrimaryPrincipal().toString());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleName = roleService.selectByUserId(userId);
        info.setRoles(roleName);
        //Set<String> permissions = userService.findPermissions(username);
        //info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 登陆认证
     * subject.login(token) 时调用
     *
     * @param token 放着emailAddress和password。
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户email和密码
        String emailAdress = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        boolean isValidUser = loginService.hasMatchUser(emailAdress, password);
        if (isValidUser) {
            User user = loginService.getUserByEmail(emailAdress);
            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
        } else {
            User user = loginService.getUserByEmail(emailAdress);
            if (user == null) {
                throw new UnknownAccountException();
            } else {
                throw new IncorrectCredentialsException();
            }
        }

    }

}
