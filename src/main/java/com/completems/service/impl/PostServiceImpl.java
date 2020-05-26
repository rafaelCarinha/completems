package com.completems.service.impl;

import com.completems.model.Post;
import com.completems.repository.PostRepository;
import com.completems.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post){
        return postRepository
                .save(post.toBuilder()
                        .createdAt(LocalDateTime.now())
                        .build());
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
