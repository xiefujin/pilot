package org.beautiful.pilot.service;

import java.util.List;

import org.beautiful.pilot.entity.Menu;

public interface MenuService {
	List<Menu> findByUserName(String username);
}
