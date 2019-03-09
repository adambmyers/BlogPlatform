package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wecancodeit.blogsite.repositories.PostRepository;

@Controller
public class PostController {

	@Resource
	PostRepository posts;
	
	@GetMapping("/posts/{id}")
	public String post(@PathVariable Long id, Model model) {
		model.addAttribute("post", posts.findById(id).get());
		return "post";
	}
}
