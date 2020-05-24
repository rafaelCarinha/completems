package com.completems.service;

import com.completems.model.Post;

public interface PostService {

    Post save(Post post);
    Iterable<Post> findAll();
    void delete(Post post);
    void deleteById(Long id);

}
