package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao{

	// private final String url = "jdbc:oracle:thin:@10.37.129.3:1521:xe";

	@Autowired
	private SqlSession sqlsession;
	
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list = sqlsession.selectList("guestbook.selectList");
		System.out.println(list.toString());
		return list;
	}
	
	/*
	 * public int insert(GeustBookVo vo) { int count =
	 * sqlsession.insert("geustbook.insert",vo); return count; }
	 */
	
	public int delete(GuestBookVo vo) {
		int count = sqlsession.delete("guestbook.delete",vo);
		return count;
	}
	
	public int insert(String id , String password, String noticeBoard) {
	    Map<String, Object> geustBookMap = new HashMap<String, Object>();
	    geustBookMap.put("id", id);
	    geustBookMap.put("password", password);
	    geustBookMap.put("noticeBoard", noticeBoard);

	    int count = sqlsession.insert("guestbook.insert", geustBookMap);
	    return count;
	}
	
	public GuestBookVo getVo(int no) {
		
		GuestBookVo  vo = sqlsession.selectOne("guestbook.getbyno", no);
		return vo;
	}
	
}