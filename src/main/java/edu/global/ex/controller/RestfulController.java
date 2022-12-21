package edu.global.ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController //기존의 jsp기반의 controller가 아님을 알려줌, Restful 기반임을 알려주는 에너테이션
@RequestMapping("/restful")
public class RestfulController {

	@GetMapping("/")
	public String restMain() {
		return "<h1>안녕히 계세요 ~~</h1>";
	}

}
