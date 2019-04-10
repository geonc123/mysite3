package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserServlet {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinform() {
		System.out.println("joinform start ");
		return "user/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("join user");
		System.out.println(userVo.toString());
		 userService.join(userVo);
		return "user/joinsuccess";
	}

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("login form start");
		return "user/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		UserVo authUser = userService.login(email, password);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
		
		
		return "redirect:/main";
				}else {return "redirect:/user/loginform?result=fail";}
		

		
	}
	
	@RequestMapping(value = "modifyform" , method = RequestMethod.POST)
	public String modifyId() {
		return "";
	}
	/*
	 * if ("joinform".equals(actionName)) { WebUtil.forword(request, response,
	 * "/WEB-INF/views/user/joinform.jsp"); } else if ("join".equals(actionName)) {
	 * 
	 * String name = request.getParameter("name"); String email =
	 * request.getParameter("email"); String password =
	 * request.getParameter("password"); String gender =
	 * request.getParameter("gender");
	 * 
	 * UserVo userVo = new UserVo(name, email, password, gender);
	 * System.out.println(userVo.toString());
	 * 
	 * UserDao dao = new UserDao(); dao.insert(userVo);
	 * 
	 * WebUtil.forword(request, response, "/WEB-INF/views/user/joinsuccess.jsp");
	 * 
	 * } else if ("loginform".equals(actionName)) { WebUtil.forword(request,
	 * response, "/WEB-INF/views/user/loginform.jsp"); } else if
	 * ("login".equals(actionName)) { String email = request.getParameter("email");
	 * String password = request.getParameter("password");
	 * 
	 * System.out.println(email); System.out.println(password);
	 * 
	 * UserDao dao = new UserDao(); UserVo uservo = dao.getUser(email, password); //
	 * System.out.println(uservo.toString());
	 * 
	 * if (uservo == null) {// 로그인 실패 WebUtil.redirect(request, response,
	 * "/mywebproject4/user?action=loginform&result=fail"); } else { // 로그인 성공
	 * HttpSession session = request.getSession(); session.setAttribute("authUser",
	 * uservo);
	 * 
	 * WebUtil.redirect(request, response, "/mywebproject4/main");
	 * 
	 * }
	 * 
	 * } else if ("logout".equals(actionName)) { HttpSession session =
	 * request.getSession(); session.removeAttribute("authUser");
	 * session.invalidate();
	 * 
	 * WebUtil.redirect(request, response, "/mywebproject4/main");
	 * 
	 * } else if ("modifyform".equals(actionName)) {
	 * 
	 * WebUtil.forword(request, response, "/WEB-INF/views/user/modifyform.jsp"); }
	 * else if ("modify".equals(actionName)) { HttpSession session =
	 * request.getSession(); UserVo authUser =
	 * (UserVo)session.getAttribute("authUser"); String name =
	 * request.getParameter("name"); String password =
	 * request.getParameter("password"); String gender =
	 * request.getParameter("gender"); int no = authUser.getNo();
	 * authUser.setName(name); authUser.setPassword(password);
	 * authUser.setGender(gender);
	 * 
	 * 
	 * 
	 * UserDao dao = new UserDao(); int flag = dao.update(name, password, gender,
	 * no); if(flag == 1) { session.setAttribute("authUser", authUser); }
	 * WebUtil.redirect(request, response, "/mywebproject4/main"); } }
	 * 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doGet(request, response);
	 * 
	 * }
	 */

}
