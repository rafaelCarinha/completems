package com.completems.service;

import com.completems.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostService extends CrudRepository<Post, Long> {
}
