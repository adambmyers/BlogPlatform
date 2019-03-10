package com.wecancodeit.blogsite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wecancodeit.blogsite.models.Author;
import com.wecancodeit.blogsite.models.Genre;
import com.wecancodeit.blogsite.models.Post;
import com.wecancodeit.blogsite.models.Tag;
import com.wecancodeit.blogsite.repositories.AuthorRepository;
import com.wecancodeit.blogsite.repositories.GenreRepository;
import com.wecancodeit.blogsite.repositories.PostRepository;
import com.wecancodeit.blogsite.repositories.TagRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	AuthorRepository authors;
	@Resource
	GenreRepository genres;
	@Resource
	PostRepository posts;
	@Resource
	TagRepository tags;
	
	@Override
	public void run(String... args) throws Exception {
		Author author1 = authors.save(new Author("Steven Pressfield"));
		Genre genre1 = genres.save(new Genre("Writing"));
		Tag tag1 = tags.save(new Tag("Self Help"));
		Tag tag2 = tags.save(new Tag("Resistance"));
		LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time1 = now1.format(formatter1);
		posts.save(new Post("The War of Art", "Read this one first. It identifies the enemy—what I call Resistance with a capital “R,” i.e. fear, self-doubt, procrastination, perfectionism, all the forms of self-sabotage that stop us from doing our work and realizing our dreams. Start here. Everything else proceeds from this.", time1, genre1, author1, tag1, tag2));
		
		Author author2 = authors.save(new Author("Adam Myers"));
		Genre genre2 = genres.save(new Genre("Technology"));
		Tag tag3 = tags.save(new Tag("Java"));
		Tag tag4 = tags.save(new Tag("Spring"));
		LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time2 = now2.format(formatter2);
		posts.save(new Post("SSR with Spring", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", time2, genre2, author2, tag1, tag2));
	}

}
