package com.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springdata.Repository.UserRepository;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Company: xiaoma.com</p> 
 * @author lizhe
 * @date 2014年7月9日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@RequestMapping("/form")
	public String form(){
		return "user/form";
	}
	
	
}
