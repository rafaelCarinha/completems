package com.completems.service;

import com.completems.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CommentService extends CrudRepository<Comment, Long> {
}
