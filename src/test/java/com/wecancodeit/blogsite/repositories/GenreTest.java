package com.wecancodeit.blogsite.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wecancodeit.blogsite.models.Genre;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class GenreTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private GenreRepository genres;
	
	@Test
	public void shouldSaveAndLoadAuthor() {
		Genre genre = genres.save(new Genre("Genre"));
		
		entityManager.persist(genre);
		entityManager.flush();
		entityManager.clear();
		
		Genre genreFromDatabase = genres.findByGenreName("Genre");
		
		assertThat(genreFromDatabase.getGenreName(), is("Genre"));
	}
}
