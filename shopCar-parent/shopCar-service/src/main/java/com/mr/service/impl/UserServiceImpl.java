package com.mr.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.entity.User;
import com.mr.mapper.UserMapper;
import com.mr.service.UserService;
import com.mr.util.Json;
import com.mr.util.RedisUtil;

@Service
public class UserServiceImpl implements UserService{
	
		@Autowired
		private UserMapper userMapper;

		@Override
		public Json login(User user, HttpSession session) {
			Json json=new Json();
			User returnUser=userMapper.login(user);
			if(returnUser==null){
				json.setMsg("账号或密码错误");
				json.setSuccess(false);
			}else{
				json.setMsg("登录成功");
				RedisUtil.setObject(session.getId(), returnUser);
				json.setSuccess(true);
			}
			return json;
		}

}
