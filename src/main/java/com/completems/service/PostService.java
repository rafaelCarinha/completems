package com.completems.service;

import com.completems.dto.PostDTO;
import com.completems.model.Post;

public interface PostService {

    PostDTO save(PostDTO post);
    Iterable<Post> findAll();
    Post findById(Long id);
    void deleteById(Long id);

}
