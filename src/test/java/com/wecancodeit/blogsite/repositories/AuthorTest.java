package com.wecancodeit.blogsite.repositories;

import javax.annotation.Resource;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wecancodeit.blogsite.models.Author;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AuthorTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private AuthorRepository authors;
	
	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author = authors.save(new Author("Parker"));
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.clear();
		
		Author authorFromDatabase = authors.findByAuthorName("Parker");
		
		assertThat(authorFromDatabase.getAuthorName(), is("Parker"));
	}
}
