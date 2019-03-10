package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wecancodeit.blogsite.repositories.PostRepository;

@Controller
public class HomeController {
	
	@Resource
	PostRepository posts;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("posts", posts.findAll());
		return "home";
	}
}
