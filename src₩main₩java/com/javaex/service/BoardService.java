package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	 static int listSize = 10;
	@Autowired
	private BoardDao dao;
	
	  public Map<String, Object> getList(int pageno) { int pageno1 =
	  1+listSize*(pageno-1); int pageno2 = listSize*pageno; int countPage = 10; int
	  maxPage = (int)Math.ceil((double)countPage/listSize); List<BoardVo> list =
	  dao.getList(pageno1, pageno2); Map<String, Object> map = new HashMap<String ,
	  Object>(); map.put("maxPage", maxPage); map.put("list", list);
	  
	  return map; }
	 
	
	public Map<String, Object> searchList(String searchKwd, int pageno){
		String searchKwd1 = "%"+searchKwd+"%";
		int pageno1 = 1+listSize*(pageno-1);
		int pageno2 = listSize*pageno;
		int countPage = dao.count(searchKwd1);
		int maxPage = (int)Math.ceil((double)countPage/listSize);
		List<BoardVo> list = dao.search(searchKwd1,pageno1, pageno2);
		Map<String, Object> map = new HashMap<String , Object>();
		map.put("maxPage", maxPage);
		map.put("list", list);
		
		return map;
	}

	public int delete(int no) {
		int count = dao.delete(no);

		return count;
	}

	
	@Transactional
	public BoardVo getBoard(int no) {
		// 조회수 1 증가 
		dao.upHit(no);
		
		// 해당글 가져오기 
		BoardVo geustBookVo = dao.getVo(no);
		return geustBookVo;
	}
 
	public int writeBoard(BoardVo boardVo) {
		int count  = dao.insert(boardVo);
		return count;
	}
	
	public BoardVo modifyform(int no) {
		BoardVo geustBookVo = dao.getVo(no);
		return geustBookVo;
	}

	public int modifyBoard(BoardVo geustBookVo) {

		int count = dao.modify(geustBookVo);

		return count;
	}
	
	
	public int insertDemo() {
		int count = dao.insertDemo();
		return count ;
	}
}
