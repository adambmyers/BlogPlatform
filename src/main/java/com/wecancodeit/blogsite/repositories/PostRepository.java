package com.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wecancodeit.blogsite.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
