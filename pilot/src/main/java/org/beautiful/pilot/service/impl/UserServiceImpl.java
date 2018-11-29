package org.beautiful.pilot.service.impl;

import org.beautiful.pilot.entity.User;
import org.beautiful.pilot.repository.UserRepository;
import org.beautiful.pilot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
 
	@Override
	@Transactional
	public void addUser(User u) {
		userRepository.save(u);
	}
 
	@Override
	public User findByName(String name) {
		return userRepository.findOneByUsername(name);
	}
}
