package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	  @RequestMapping(value = "/list/{pageno}", method = RequestMethod.GET) public
	  String list(Model model, @PathVariable(value = "pageno", required = false)
	  int pageno) { System.out.println("get list"); Map<String, Object> map =
	  boardService.getList(pageno);
	  
	  model.addAttribute("maxPage", map.get("maxPage"));
	  model.addAttribute("guestList", map.get("list")); System.out.println(pageno);
	  return "board/list";
	  
	  }
	 
	 

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeBoard(@ModelAttribute BoardVo boardVo) {
		System.out.println("insert vo ");
		boardService.writeBoard(boardVo);
		return "redirect:/board/list/1";
	}

	@RequestMapping(value = "writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("write form");
		return "board/writeform";
	}

	@RequestMapping(value = "/modifyform/{no}", method = RequestMethod.GET)
	public String modifyForm(@PathVariable("no") int no, Model model) {
		System.out.println("modify form start");
		BoardVo boardVo = boardService.modifyform(no);
		model.addAttribute("getUser", boardVo);
		return "board/modifyform";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVo boardVo) {
		System.out.println("modify exe");
		boardService.modifyBoard(boardVo);
		return "redirect:/board/list/1";
	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") int no) {
		System.out.println("delete exe");
		boardService.delete(no);
		return "redirect:/board/list/1";
	}

	@RequestMapping(value = "/read/{no}", method = RequestMethod.GET)
	public String read(@PathVariable("no") int no, Model model) {
		System.out.println(no);
		System.out.println("read start");
		BoardVo boardVo = boardService.getBoard(no);
		model.addAttribute("getList", boardVo);

		return "board/read";
	}

	@RequestMapping(value = "/insert/demo/doNotOpen", method = RequestMethod.GET)
	public String insertDemo() {
		boardService.insertDemo();
		return "redirect:/board/list/1";
	}

	@RequestMapping(value = "/search/{pageno}", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchElse(@RequestParam(value = "searchKwd", required = false, defaultValue = "") String searchKwd,
			Model model, @PathVariable(value = "pageno") int pageno) {
		Map<String, Object> map = boardService.searchList(searchKwd, pageno);

		model.addAttribute("maxPage", map.get("maxPage"));
		model.addAttribute("guestList", map.get("list"));

		return "board/list";
	}

}
