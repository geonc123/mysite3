package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDao;
import com.javaex.vo.RboardVo;

@Service
public class RboardService {

	@Autowired
	private RboardDao dao;

	public List<RboardVo> getList() {
		List<RboardVo> list = dao.getList();
		return list;
	}

	public int writeBoard(RboardVo rboardVo) { // group_no 어떠케 할지 고민해보자!
		rboardVo.setGroup_no(1);
		int count = dao.insert(rboardVo);

		return count;
	}

	public int inWriteBoard(RboardVo rboardVo) {
		System.out.println(rboardVo.getUser_no());
		System.out.println(rboardVo.getTitle());
		System.out.println(rboardVo.getContent());
		System.out.println(rboardVo.getGroup_no());
		System.out.println(rboardVo.getOrder_no());
		int group_no = rboardVo.getGroup_no();
		int order_no = dao.selectCount(group_no)+1;
		rboardVo.setOrder_no(order_no);
		System.out.println(rboardVo.getOrder_no());
		int count = dao.ininsert(rboardVo);
		return count ;
	}

	public int in_inWriteBoard(RboardVo rboardVo) {
		System.out.println(rboardVo.getUser_no());
		System.out.println(rboardVo.getTitle());
		System.out.println(rboardVo.getContent());
		System.out.println(rboardVo.getGroup_no());
		System.out.println(rboardVo.getOrder_no());
		System.out.println(rboardVo.getDepth());
		int depth_no = rboardVo.getDepth()+1;
		int group_no = rboardVo.getGroup_no();
		int order_no = rboardVo.getOrder_no()+1;
		rboardVo.setOrder_no(order_no);
		rboardVo.setDepth(depth_no);
		dao.updateIn_inwrite(rboardVo.getGroup_no(), 
							order_no, 
							dao.selectCount(group_no)
							);
		int count = dao.in_ininsert(rboardVo);
		
		
		return count;
	}
	
	public int deleteList (int no) {
		System.out.println(no);
		
		int count = dao.deadpoint(no);
		return count ;
	}
	
	public RboardVo getRboard(int no) {
		RboardVo rboardVo = dao.selectOnt(no);
		return rboardVo;
	}
}
