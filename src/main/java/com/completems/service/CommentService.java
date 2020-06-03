package com.completems.service;

import com.completems.dto.CommentDTO;
import com.completems.model.Comment;

public interface CommentService {

    CommentDTO save(CommentDTO comment);
    Iterable<Comment> findAll();
    void deleteById(Long id);
}
