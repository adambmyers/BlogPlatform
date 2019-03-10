package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wecancodeit.blogsite.repositories.GenreRepository;

@Controller
public class GenreController {
	
	@Resource
	GenreRepository genres;
	
	@GetMapping("/genres/{id}")
	public String genre(@PathVariable Long id, Model model) {
		model.addAttribute("genre", genres.findById(id).get());
		return "genre";
	}
	
}
