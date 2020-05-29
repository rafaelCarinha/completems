package com.completems.service;

import com.completems.model.Comment;

public interface CommentService {

    Comment save(Comment comment);
    Iterable<Comment> findAll();
    void deleteById(Long id);
}
