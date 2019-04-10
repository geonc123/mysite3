package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;



@Service
public class GuestBookService {

	@Autowired
	private GuestBookDao dao;
	
	public int insert(String id, String password, String noticeBoard) {
		int count = dao.insert(id, password, noticeBoard);
		
		return count;
	}
	
	public GuestBookVo getVo(int no) {
		GuestBookVo geustVo = dao.getVo(no);
		return geustVo ;
	}
	
	public int delete(GuestBookVo guestVo) {
		int count = dao.delete(guestVo);
		return count;
	}
	
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list = dao.getList();
		return list;
	}
	
}
