package kr.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main/main.do")
	public String main() {
		       //뷰 이름(타일스 식별자)
		return "main";
	}
	
}
