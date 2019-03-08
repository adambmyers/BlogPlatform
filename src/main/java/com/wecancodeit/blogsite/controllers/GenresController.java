package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wecancodeit.blogsite.models.Genre;
import com.wecancodeit.blogsite.repositories.GenreRepository;

@Controller
public class GenresController {
	@Resource
	GenreRepository genres;
	
	@GetMapping ("/genres")
	public String genres(Model model) {
		model.addAttribute("genres", genres.findAll());
		return "genres";
	}
	
	@PostMapping ("/genres")
	public String submitGenre(String genreName) {
		genres.save(new Genre(genreName));
		return "redirect:/genres";
	}
}
