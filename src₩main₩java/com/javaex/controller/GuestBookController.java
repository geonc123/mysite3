package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
private GuestBookService guestService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("id") String id, @RequestParam("password") String password,
			@RequestParam("noticeBoard") String noticeBoard) {
		System.out.println("add vo");
		guestService.insert(id, password, noticeBoard);
		return "redirect:/guestbook/addList";
	}

	@RequestMapping(value = "/deleteform/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("delete form start");
		GuestBookVo vo = (GuestBookVo) guestService.getVo(no);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		return "guest/deleteform";

	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestBookVo guestVo) {
		System.out.println("delete vo ");
		System.out.println(guestVo.toString());
		guestService.delete(guestVo);
		return "redirect:/guestbook/addList";
	}

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("get list");
		List<GuestBookVo> list = guestService.getList();

		model.addAttribute("list", list);
		return "guest/addlist";

	}
}
