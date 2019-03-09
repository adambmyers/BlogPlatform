package com.wecancodeit.blogsite.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private LocalDateTime time;
	@Lob
	private String body;
	
	@ManyToMany
	private Collection<Author> authors;
	
	@ManyToOne
	private Genre genre;
	
	@ManyToMany
	private Collection<Tag> tags;

	public Post() {}
	
	public Post(String title, String body, LocalDateTime time, Genre genre, Author author, Tag ...tags) {
		this.title = title;
		this.body = body;
		this.genre = genre;
		this.time = time;
		this.authors = Arrays.asList(author);
		this.tags = Arrays.asList(tags);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}
	
	public LocalDateTime getTime() {
		return time;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public Genre getGenre() {
		return genre;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", authors=" + authors + ", genre=" + genre
				+ ", tags=" + tags + "]";
	}
	
	
}
