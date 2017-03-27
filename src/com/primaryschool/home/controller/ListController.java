package com.primaryschool.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {

	
	@RequestMapping("/details")
	public String details(){
		return "home/list/trendsList";
	}
}
