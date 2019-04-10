package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;

	public List<BoardVo> getList(int pageno1,int pageno2) {
		List<BoardVo> list = dao.getList(pageno1, pageno2);

		return list;
	}

	public int delete(int no) {
		int count = dao.delete(no);

		return count;
	}

	public BoardVo getBoard(int no) {
		BoardVo geustBookVo = dao.getVo(no);
		dao.upHit(no);
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
	
	public int countPage() {
		int count = dao.count();
		return count;
	}
	
	public int insertDemo() {
		int count = dao.insertDemo();
		return count ;
	}
}
