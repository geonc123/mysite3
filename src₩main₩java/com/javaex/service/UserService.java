package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	//회원 가입 
	public int join(UserVo userVo) {
		
		int count = dao.insert(userVo);
		return count;
	}
	
	
	// 로그인 
	public UserVo login(String email, String password) {
		return dao.select(email, password);
		
	}
}
