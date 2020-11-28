package com.ocs.osj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ocs.osj.model.UserVO;

@Controller
public class BoardController {

	
	@GetMapping(path = "/boardList")
	public String getBoard() {
		return "boardList";
	}

}
