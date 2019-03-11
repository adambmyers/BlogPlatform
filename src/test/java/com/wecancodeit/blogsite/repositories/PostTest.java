package com.wecancodeit.blogsite.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wecancodeit.blogsite.models.Author;
import com.wecancodeit.blogsite.models.Genre;
import com.wecancodeit.blogsite.models.Post;
import com.wecancodeit.blogsite.models.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private AuthorRepository authors;
	
	@Resource
	private TagRepository tags;
	
	@Resource
	private GenreRepository genres;
	
	@Resource
	private PostRepository posts;
	
	@Test
	public void shouldSaveAndLoadAuthort() {
		Author author = authors.save(new Author("Author"));
		Tag tag = tags.save(new Tag("Tag"));
		Genre genre = genres.save(new Genre("Genre"));
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = now.format(formatter);
		
		Post post = posts.save(new Post("Title", "Body", time, genre, author, tag));
		
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();
		
		Post postFromDatabase = posts.findByTitle("Title");
		
		assertThat(postFromDatabase.getTitle(), is("Title"));
		assertThat(postFromDatabase.getBody(), is("Body"));
		//assertThat(postFromDatabase.getGenre(), is(genre));
	}
	
}
