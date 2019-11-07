package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(methods= {RequestMethod.GET, RequestMethod.POST})
public class UserController {

	@RequestMapping(method=RequestMethod.POST,value="/login")
	@ResponseBody
	public String login(@RequestBody User user) {
		System.out.println(user.getUsername());
		return user.getUsername()+":"+user.getPassword();
	}
}
