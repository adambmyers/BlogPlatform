package com.wecancodeit.blogsite.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wecancodeit.blogsite.models.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TagTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private TagRepository tags;
	
	@Test
	public void shouldSaveAndLoadAuthor() {
		Tag tag = tags.save(new Tag("Tag"));
		
		entityManager.persist(tag);
		entityManager.flush();
		entityManager.clear();
		
		Tag tagFromDatabase = tags.findByTagName("Tag");
		
		assertThat(tagFromDatabase.getTagName(), is("Tag"));
	}
}
