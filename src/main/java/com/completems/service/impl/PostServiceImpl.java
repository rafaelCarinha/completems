package com.completems.service.impl;

import com.completems.dto.PostDTO;
import com.completems.model.DynamoPost;
import com.completems.model.Post;
import com.completems.repository.PostRepository;
import com.completems.repository.dynamo.DynamoPostRepository;
import com.completems.service.PostService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private DynamoPostRepository dynamoPostRepository;

    public PostServiceImpl(PostRepository postRepository, DynamoPostRepository dynamoPostRepository) {
        this.postRepository = postRepository;
        this.dynamoPostRepository = dynamoPostRepository;
    }

    @Override
    public PostDTO save(PostDTO post){
/*        return PostDTO.entityToDTO(postRepository
                .save(Post.builder()
                        .createdAt(LocalDateTime.now())
                        .content(post.getContent())
                        .name(post.getName())
                        .title(post.getTitle())
                        .build()));*/
        return PostDTO.entityToDTO(dynamoPostRepository
                .save(DynamoPost.builder()
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
    public Iterable<DynamoPost> findAll() {
        return dynamoPostRepository.findAll();
    }

    @Override
    public Post findById(String id) throws EntityNotFoundException {
        return postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity not found with id: "+id));
    }

    @Override
    public void deleteById(String id) {
        postRepository.deleteById(id);
    }
}
