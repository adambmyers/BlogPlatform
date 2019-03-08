package com.wecancodeit.blogsite.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Long id;
	private String genreName;
	
	@OneToMany
	private Collection<Post> posts;
	
	public Genre() {}
	
	public Genre(String genreName) {
		this.genreName = genreName;
	}

	public Long getId() {
		return id;
	}

	public String getGenreName() {
		return genreName;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreName=" + genreName + "]";
	}
	
}
