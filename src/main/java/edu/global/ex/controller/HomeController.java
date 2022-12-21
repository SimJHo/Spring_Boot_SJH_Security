package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "main";
	}
	
	@GetMapping("/user/userHome")
	public void userHome() {
		log.info("userHome()..");
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome()..");
	}
	
}
