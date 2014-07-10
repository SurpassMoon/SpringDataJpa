package com.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springdata.Repository.UserRepository;
import com.springdata.model.Role;
import com.springdata.model.User;

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
	
	@RequestMapping(value="/form/{id}", method=RequestMethod.POST)
	public String form(@PathVariable String id, User user,String param,List<Integer> params){
		/*for (Role role : user.getRoles()) {
			System.out.println(role.getName());
		}
		for (String num : user.getNum()) {
			System.out.println(num);
		}*/
System.out.println(params.get(0));		
		System.out.println(param);		
System.out.println(id);		
		return "user/form";
	}
	
	
}
