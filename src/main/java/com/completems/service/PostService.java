package com.completems.service;

import com.completems.dto.PostDTO;
import com.completems.model.DynamoPost;
import com.completems.model.Post;

public interface PostService {

    PostDTO save(PostDTO post);
    PostDTO update(PostDTO post);
    Iterable<DynamoPost> findAll();
    Post findById(String id);
    void deleteById(String id);

}
