package org.beautiful.pilot.service;

import org.beautiful.pilot.entity.User;

public interface UserService {
	
	void addUser(User u);
	User findByName(String name);
}
