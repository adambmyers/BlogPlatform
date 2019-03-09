package com.wecancodeit.blogsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wecancodeit.blogsite.models.Author;
import com.wecancodeit.blogsite.models.Post;
import com.wecancodeit.blogsite.models.Tag;
import com.wecancodeit.blogsite.repositories.AuthorRepository;
import com.wecancodeit.blogsite.repositories.PostRepository;
import com.wecancodeit.blogsite.repositories.TagRepository;

@Controller
public class PostController {

	@Resource
	PostRepository posts;
	@Resource
	TagRepository tags;
	@Resource
	AuthorRepository authors;
	
	@GetMapping("/posts/{id}")
	public String post(@PathVariable Long id, Model model) {
		model.addAttribute("post", posts.findById(id).get());
		return "post";
	}
	
	@PostMapping("/posts/{id}")
	public String submitAuthorOrTag(@PathVariable Long id, String tagName, String authorName) {
		Post post = posts.findById(id).get();
		
		if (tagName != null) {
			Tag tag = tags.save(new Tag(tagName));
			post.addTagToTags(tag);
			posts.save(post);
		} else if (authorName != null) {
			Author author = authors.save(new Author(authorName));
			post.addAuthorToAuthors(author);
			posts.save(post);
		}
		
		return "redirect:/posts/" +id;
	}
}
