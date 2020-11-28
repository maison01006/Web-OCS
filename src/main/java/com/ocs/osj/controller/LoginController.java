package com.ocs.osj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ocs.osj.model.PatientVO;
import com.ocs.osj.model.ReceiveService;
import com.ocs.osj.model.ReceiveVO;
import com.ocs.osj.model.UserService;
import com.ocs.osj.model.UserVO;
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	ReceiveService receiveService;
	
	@PostMapping("/login.do")
	public String login(UserVO vo,HttpSession session,Model model) {
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		List<UserVO> userList = userService.login(vo.getId(),vo.getPassword());
		if (userList.size()==1) {
			session.setAttribute("userId", userList.get(0).getId());
			session.setAttribute("userName", userList.get(0).getName());
			session.setAttribute("userType", userList.get(0).getMajorId());
			return "redirect:/main.do";
		} else
			System.out.println("실패");
		return null;
	}
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/main")
	public String goMain(HttpSession session) {
		
		if(session.getAttribute("userType").equals(1))
			return "main";
		else if(session.getAttribute("userType").equals(2))
			return "injmain";
		else if(session.getAttribute("userType").equals(3))
			return "docmain";
		else return "login";
	}

}
