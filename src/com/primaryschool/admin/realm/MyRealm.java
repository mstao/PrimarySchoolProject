package com.primaryschool.admin.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.service.IUserService;

/**
 * 
* @ClassName: MyRealm
* @Description: TODO 权限认证
* @author Mingshan
* @date 2017年4月18日 下午6:46:29
*
 */

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private IUserService<SecurityUser> userService;
	
	/**
	 * 为登录成功的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String userName=(String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo  authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.getRoles(userName));
		authorizationInfo.setStringPermissions(userService.getPermissions(userName));
		return authorizationInfo;
	}

	
	/**
	 * 验证当前的用户
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userName=(String) token.getPrincipal();
		//3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		SecurityUser user=(SecurityUser) userService.getByUerName(userName);
		System.out.println(user.getUserName()+"----"+user.getPassword());
		if(user!=null){
			
			//加点盐
			ByteSource credentialsSalt=ByteSource.Util.bytes(userName);
			
			AuthenticationInfo authInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(), credentialsSalt,realmName );
			return authInfo;
		}else{
			return null;	
		}
		
		
	}

}
