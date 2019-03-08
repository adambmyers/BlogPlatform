package com.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wecancodeit.blogsite.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{

}
