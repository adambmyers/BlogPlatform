package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wecancodeit.blogsite.repositories.AuthorRepository;
import com.wecancodeit.blogsite.repositories.GenreRepository;
import com.wecancodeit.blogsite.repositories.PostRepository;
import com.wecancodeit.blogsite.repositories.TagRepository;

@Controller
public class PostController {
	
	@Resource
	AuthorRepository authors;
	
	@Resource
	GenreRepository genres;
	
	@Resource
	PostRepository posts;
	
	@Resource
	TagRepository tags;
	

	@GetMapping ("/posts")
	public String posts(Model model) {
		model.addAttribute("authors", authors.findAll());
		model.addAttribute("genres", genres.findAll());
		model.addAttribute("posts", posts.findAll());
		model.addAttribute("tags", tags.findAll());
		return "posts";
	}

}
