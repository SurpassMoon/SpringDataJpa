package com.springdata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gradle.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdata.Repository.UserRepository;
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
	
	/** 
     * 用于处理异常的 
     * @return 
     */  
    @ExceptionHandler({MyException.class})  
    public @ResponseBody String exception(MyException e) {  
        System.out.println(e.getMessage());  
        e.printStackTrace();
        return e.getMessage();  
    }  
	 
	
    @RequestMapping(value = "/form/{id}", method = RequestMethod.POST)
    public String form(@PathVariable String id, User user, String param, List<Integer> params) {
        /*
         * for (Role role : user.getRoles()) {
         * System.out.println(role.getName()); } for (String num :
         * user.getNum()) { System.out.println(num); }
         */
System.out.println(params.get(0));
System.out.println(param);
System.out.println(id);
        return "user/form";
    }
    
    @RequestMapping(value = "test", method = RequestMethod.GET)  
    public String test() throws MyException  {  
        throw new MyException("出错了！");  
    }
	
    @RequestMapping(value="jqueryAjax", method = RequestMethod.GET)  
    public @ResponseBody String jqueryAjax() throws MyException{
        
       throw new MyException("error222");
    }
	
    public @ResponseBody  Map<String, Object> getjson() throws Exception {  
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            map.put("content", "123");  
            map.put("result", true);  
            map.put("account", 1);  
            throw new Exception();
        } catch (Exception e) {  
            throw new Exception("detail of ajax exception information");  
        }  
    } 
    
    
    
    
    
    
}
