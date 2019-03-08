package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wecancodeit.blogsite.models.Tag;
import com.wecancodeit.blogsite.repositories.TagRepository;

@Controller
public class TagController {

	@Resource
	TagRepository tags;
	
	@GetMapping ("/tags")
	public String tags(Model model) {
		model.addAttribute("tags", tags.findAll());
		return "tags";
	}
	
	@PostMapping ("/tags")
	public String submitTags(String tagName) {
		tags.save(new Tag(tagName));
		return "redirect:/tags";
	}
}
