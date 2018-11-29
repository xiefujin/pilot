package org.beautiful.pilot.service.impl;

import java.util.List;

import org.beautiful.pilot.entity.Menu;
import org.beautiful.pilot.repository.MenuRepository;
import org.beautiful.pilot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("menuService")
@Transactional(readOnly=true)
public class MenuServiceImpl  implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;
 
	@Override
	public List<Menu> findByUserName(String username) {
		// TODO Auto-generated method stub
		return menuRepository.findByUsername(username);
	}
}
