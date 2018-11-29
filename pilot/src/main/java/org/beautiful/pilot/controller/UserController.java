package org.beautiful.pilot.controller;


import org.beautiful.pilot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
	
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
	public String dologin(){
		return "/user/test";
	}

}
