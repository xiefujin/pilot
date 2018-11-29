package org.beautiful.pilot.controller;


import org.beautiful.pilot.entity.User;
import org.beautiful.pilot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	/**
	 * ��¼���
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public String register(User user){
		return "/user/register";
	}
	
	/**
	 * ��¼���
	 * @param user
	 * @return
	 */
	@RequestMapping("/doregister")
	public String doRegister(User user){
		userService.addUser(user);
		return "/user/login";
	}
	/**
	 * ��¼���
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user){
		return "/user/login";
	}
	
	
	/**
	 * ��¼��
	 * @return
	 */
	@RequestMapping("/dologin")
	public String doLogin(){
		return "/user/test";
	}

}
