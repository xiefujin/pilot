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
     * spring security ��ȫ��֤�û�����
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.beautiful.pilot.entity.User u =  userService.findByName(username);//�Լ�ϵͳ���û���
		User user  = null;
		if(null==u){
			 throw new UsernameNotFoundException("�Ҳ������˻���Ϣ��");
		}
		else{
			//spring security ������û��ֻ࣬��Ҫ���û��������룬����ɫ�б����ݽ���spring�Ϳ�����
			 user = new User(username, u.getPassword(), findPermisions(username));
		}
 
		return user;
	}
	
	
	/**
	 * �����û���ȥȷ���û�ӵ�в˵�Ȩ��
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
