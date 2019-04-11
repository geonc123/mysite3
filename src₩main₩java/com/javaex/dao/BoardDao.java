package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<BoardVo> getList(int pageno1, int pageno2 ){
		System.out.println("dao getList");
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("pageno1", pageno1);
		pageMap.put("pageno2", pageno2);
		
		List<BoardVo> list = sqlsession.selectList("board.selectList", pageMap);
		return list;
	}
	
	public int delete(int no) {
	 int count = sqlsession.delete("board.delete", no);
	 System.out.println("delete complete");
	 return count;
	}
	
	public int insert(BoardVo boardVo) {
	
		 int count = sqlsession.insert("board.insert", boardVo);
		 
		 System.out.println("insert complete");
		 return count;
		}
	
	public int modify(BoardVo boardVo) {
		int count = sqlsession.update("board.modify", boardVo);
		System.out.println("update complete");
		return count;
	}
	
	public int upHit(int no) {
		int count = sqlsession.update("board.uphit", no);
		System.out.println("up hit!!");
		return count;
	}
	

	public BoardVo getVo(int no ) {
		BoardVo boardVo = sqlsession.selectOne("board.getVo", no);
		
		return boardVo;
	}
	
	public int count(){
		int count= sqlsession.selectOne("board.count");
		return count ;
	}
	public int insertDemo() {
		int count = 0 ;
		BoardVo vo = new BoardVo();
		for(int i =0 ; i<10000 ; i++) {
			vo.setUser_no(5);
			vo.setTitle(i+"번째 타이틀");
			vo.setContent(i+"번째 컨텐트 ");
			
		 sqlsession.insert("board.insert", vo);
		 count ++;
		}
		 System.out.println("insert complete");
		 return count;
		}
	
	public List<BoardVo> search(String searchKwd) {
		List<BoardVo> list = sqlsession.selectList("board.search",searchKwd);
		return list;
	}
	 
}
