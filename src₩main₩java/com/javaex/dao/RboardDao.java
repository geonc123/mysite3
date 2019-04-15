package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {

	
	@Autowired
	private SqlSession sqlsession;
	
	public List<RboardVo> getList(){
		List<RboardVo> list = sqlsession.selectList("rboard.selectList");
		return list;
	}
	
	public int upGroupNo(int group_no) {
		int count=sqlsession.update("rboard.group_no", group_no);
		
		return count;
	}
	
	public int upHit(int hit_no) {
		int count = sqlsession.update("rboard.upHit", hit_no);

		return count;
	}
	
	public int upOrderNo(int order_no) {
		int count = sqlsession.update("rboard.order_no", order_no);

		return count;
	}
	
	public int upDepth(int depth_no) {
		int count = sqlsession.update("rboard.depth", depth_no);

		return count;
	}
	
	public int updateTitle(String title, int no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("no", no);
		int count = sqlsession.update("rboard.", map);
		
		return count ;
	}
	public int updateContent(String content , int no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		map.put("no", no);
		int count = sqlsession.update("rboard.", map);
		return count ; 
	}
	public int updateHit(int hit) {


		int count = sqlsession.update("rboard.", hit);
		return count ;
	}
	

	public int insert(RboardVo rboardVo) {
		int count = sqlsession.insert("rboard.insert", rboardVo);

		return count;
	}
	public int ininsert(RboardVo rboardVo) {
		int count = sqlsession.insert("rboard.ininsert", rboardVo);

		return count;
	}
	public int in_ininsert(RboardVo rboardVo) {
		int count = sqlsession.insert("rboard.in_ininsert", rboardVo);

		return count;
	}
	
	public int selectCount(int group_no) {
		int count = sqlsession.selectOne("rboard.count", group_no);
		return count;
	}
	
	public int updateIn_inwrite( int group_no, int order_no_1,int order_no_2) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("group_no", group_no); 
		map.put("order_no_1", order_no_1);
		map.put("order_no_2", order_no_2);
		int count = sqlsession.update("rboard.updateIn_InwriteOrder_no", map);
		return count;
	}
	
	public int deadpoint(int no) {
		int count = sqlsession.update("rboard.deadpoint", no);
		return count ;
	}
	
	public RboardVo selectOnt(int no) {
		RboardVo rboardVo = sqlsession.selectOne("rboard.selectOne", no);
		return rboardVo;
	}
	
	public int modify(RboardVo rboardVo) {
		int count = sqlsession.update("rboard.modify", rboardVo);
		return count;
	}
}
