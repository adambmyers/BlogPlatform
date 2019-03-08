package com.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wecancodeit.blogsite.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
