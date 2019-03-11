package com.wecancodeit.blogsite.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.wecancodeit.blogsite.models.Author;
import com.wecancodeit.blogsite.repositories.AuthorRepository;

public class AuthorControllerTest {
	
	@InjectMocks
    private AuthorsController underTest;
 
    @Mock
    private AuthorRepository authorRepo;
 
    @Mock
    private Author author;
    
	@Mock
	private Model model;
 
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldAddBookToModel() throws Exception { 
        Long id = 1L;
    	when(authorRepo.findById(id)).thenReturn(Optional.of(author));
 
        underTest.authors(model);
 
        verify(model).addAttribute("authors", author);
    }
}
