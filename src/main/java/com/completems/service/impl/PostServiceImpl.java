package com.completems.service.impl;

import com.completems.dto.PostDTO;
import com.completems.model.Post;
import com.completems.repository.PostRepository;
import com.completems.service.PostService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO save(PostDTO post){
        return PostDTO.entityToDTO(postRepository
                .save(Post.builder()
                        .createdAt(LocalDateTime.now())
                        .content(post.getContent())
                        .name(post.getName())
                        .title(post.getTitle())
                        .build()));
    }

    @Override
    public PostDTO update(PostDTO post){
        return PostDTO.entityToDTO(postRepository
                .save(Post.builder()
                        .id(post.getId())
                        .updatedAt(LocalDateTime.now())
                        .content(post.getContent())
                        .name(post.getName())
                        .title(post.getTitle())
                        .build()));
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) throws EntityNotFoundException {
        return postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity not found with id: "+id));
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
