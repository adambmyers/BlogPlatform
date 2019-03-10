package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wecancodeit.blogsite.repositories.TagRepository;

@Controller
public class TagController {
	
	@Resource
	TagRepository tags;
	
	@GetMapping("/tags/{id}")
	public String tag(@PathVariable Long id, Model model) {
		model.addAttribute("tag", tags.findById(id).get());
		return "tag";
	}
	
}
