package org.beautiful.pilot.service;

import java.util.List;

import org.beautiful.pilot.entity.Menu;
import org.springframework.data.jpa.repository.Query;

public interface MenuService {
	
	List<Menu> findByUserName(String username);
}
