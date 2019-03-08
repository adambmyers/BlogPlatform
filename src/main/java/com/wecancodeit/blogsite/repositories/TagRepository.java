package com.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wecancodeit.blogsite.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
