package com.wecancodeit.blogsite.controllers;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wecancodeit.blogsite.models.Author;
import com.wecancodeit.blogsite.models.Genre;
import com.wecancodeit.blogsite.models.Post;
import com.wecancodeit.blogsite.models.Tag;
import com.wecancodeit.blogsite.repositories.AuthorRepository;
import com.wecancodeit.blogsite.repositories.GenreRepository;
import com.wecancodeit.blogsite.repositories.PostRepository;
import com.wecancodeit.blogsite.repositories.TagRepository;

@Controller
public class PostsController {
	
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
	
	@PostMapping ("/posts")
	public String postSubmit(String title, String body, String authorName, String genreName, String tagName) {
//		Collection<Tag> currentTags = null;
//		String[] tagNames = tagName.split(",");
//		for (String tag : tagNames) {
//			 Tag tagToAdd = tags.findByTagName(tagName);
//			 currentTags.add(tagToAdd);
//		}
		
		LocalDateTime time = LocalDateTime.now();
		Author author = authors.findByAuthorName(authorName);
		Genre genre = genres.findByGenreName(genreName);
		Tag tag = tags.findByTagName(tagName);
		posts.save(new Post(title, body, time, genre, author, tag));
		return "redirect:/posts";	
	}
}
