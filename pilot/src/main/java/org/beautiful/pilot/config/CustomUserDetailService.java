package org.beautiful.pilot.config;

import java.util.ArrayList;
import java.util.List;

import org.beautiful.pilot.entity.Menu;
import org.beautiful.pilot.service.MenuService;
import org.beautiful.pilot.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailService implements UserDetailsService{

    private Logger logger = LoggerFactory.getLogger(getClass());
	
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MenuService menuService;
	
    
    
    /**
     * spring security 安全验证用户方法
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.beautiful.pilot.entity.User u =  userService.findByName(username);//自己系统的用户类
		User user  = null;
		if(null==u){
			 throw new UsernameNotFoundException("找不到该账户信息！");
		}
		else{
			//spring security 管理的用户类，只需要将用户名，密码，及角色列表数据交给spring就可以了
			 user = new User(username, u.getPassword(), findPermisions(username));
		}
 
		return user;
	}
	
	
	/**
	 * 根据用户名去确定用户拥有菜单权限
	 * @param username
	 * @return
	 */
	public List<GrantedAuthority> findPermisions(String username){
		List<GrantedAuthority> list = new ArrayList<>();
		List<Menu> menus =   menuService.findByUserName(username);
		for (Menu menu : menus) {
			list.add(new SimpleGrantedAuthority(menu.getMenuPermission()));
		}
		return list;
	}	
}
