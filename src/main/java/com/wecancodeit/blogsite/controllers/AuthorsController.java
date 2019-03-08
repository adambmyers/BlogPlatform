package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wecancodeit.blogsite.models.Author;
import com.wecancodeit.blogsite.repositories.AuthorRepository;

@Controller
public class AuthorsController {
	@Resource
	AuthorRepository authors;
	
	@GetMapping ("/authors")
	public String authors(Model model) {
		model.addAttribute("authors", authors.findAll());
		return "authors";
	}
	
	@PostMapping ("/authors")
	public String submitAuthor(String authorName) {
		authors.save(new Author(authorName));
		return "redirect:/authors";
	}
}
