package com.wecancodeit.blogsite.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String authorName;
	
	@ManyToMany
	private Collection<Post> posts;
	
	public Author() {}
	
	public Author(String authorName) {
		this.authorName = authorName;
	}

	public Long getId() {
		return id;
	}

	public String getAuthorName() {
		return authorName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + "]";
	}
	
	
}
