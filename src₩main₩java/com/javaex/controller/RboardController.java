package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
@RequestMapping("/rboard")
public class RboardController {

	
	@Autowired
	private RboardService rboardService;
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String listPage(Model model) {
		System.out.println("get list");
		List<RboardVo> list = rboardService.getList();
		System.out.println(list.toString());
		model.addAttribute("boardList", list);
		return "rboard/list"; 
	}
	
	@RequestMapping(value = "/writeform", method = RequestMethod.GET)
	public String writeBoardForm() {
		
		return "rboard/writeform" ;
	}
	@RequestMapping(value = "/inwriteform", method = RequestMethod.GET)
	public String inwriteBoardForm(@RequestParam("order_no") int order_no , 
									@RequestParam("group_no") int group_no
									 ) {
	
		return "rboard/inwriteform" ;
	}
	@RequestMapping(value = "/in_inwriteform", method = RequestMethod.GET)
	public String in_inwriteBoardForm(@RequestParam("order_no") int order_no , 
									  @RequestParam("group_no") int group_no ,
									  @RequestParam("depth") int depth) {
		
		return "rboard/in_inwriteform" ;
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeBoard(@ModelAttribute RboardVo rboardVo) {
		
		System.out.println("write start");
		rboardService.writeBoard(rboardVo);
		
		return "redirect:/rboard/list";
	}
	
	@RequestMapping(value = "inwrite", method = RequestMethod.POST)
	public String inWriteBoard(@ModelAttribute RboardVo rboardVo) {
		
		System.out.println("in write start");
		rboardService.inWriteBoard(rboardVo);
		return "redirect:/rboard/list";
		
	}
	
	@RequestMapping(value = "in_inwrite", method = RequestMethod.POST)
	public String in_inWriteBoard(@ModelAttribute RboardVo rboardVo) {
		System.out.println("in-in write start");
		rboardService.in_inWriteBoard(rboardVo);
		return "redirect:/rboard/list"; 
	}
	
	@RequestMapping(value = "delete" , method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no) {
		rboardService.deleteList(no);
		return "redirect:/rboard/list";
	}
	
	@RequestMapping(value = "read" , method = RequestMethod.GET)
	public String read(@RequestParam("no") int no , Model model) {
		RboardVo rboardVo = rboardService.getRboard(no);
		model.addAttribute("getList", rboardVo);
		return "rboard/read";
	}
	
	@RequestMapping(value = "modifyform", method = RequestMethod.GET)
	public String modifyForm(@RequestParam("no") int no ) {
		
		return "rboard/modifyform" ;
	}
	
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute RboardVo rboardVo) {
		rboardService.modify(rboardVo);
		return "redirect:/rboard/list";
	}

}
