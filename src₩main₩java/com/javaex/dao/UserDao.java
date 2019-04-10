package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	// user join
	public int insert(UserVo userVo) {
		System.out.println("dao insert exe");
		int count = sqlSession.insert("user.insert", userVo);
		return count;
	}
	//user login
	public UserVo select(String email, String password) {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("email", email);
		userMap.put("password", password);
		System.out.println("dao select exe");
		return sqlSession.selectOne("user.select", userMap);
	}
	}
