package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wecancodeit.blogsite.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	@Resource
	AuthorRepository authors;
	
	@GetMapping ("/authors/{id}")
	public String author(@PathVariable Long id, Model model) {
		model.addAttribute("author", authors.findById(id).get());
		return "author";
	}
}
