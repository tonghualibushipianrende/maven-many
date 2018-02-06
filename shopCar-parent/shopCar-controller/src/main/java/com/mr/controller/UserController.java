package com.mr.controller;

import javax.servlet.http.HttpSession;
import javax.ws.rs.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mr.entity.User;
import com.mr.service.UserService;
import com.mr.util.Json;

@Controller
@RequestMapping(value="user")
public class UserController {
	
		@Autowired
		private UserService userService;
		
		@RequestMapping(value="login")
		public String login(User user,ModelMap map,HttpSession session){
			Json json=userService.login(user,session);
			if(json.getSuccess()){
				return "goods/show-page";
			}else{
				map.put("msg", json.getMsg());
				return "../../index";
			}
		}
		@RequestMapping(value="toShowPage")
		public String toShowPage(){
			return "goods/show-page";
		}

}
