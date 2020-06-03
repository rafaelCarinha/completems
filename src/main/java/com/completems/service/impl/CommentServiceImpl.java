package com.completems.service.impl;

import com.completems.dto.CommentDTO;
import com.completems.model.Comment;
import com.completems.model.DynamoComment;
import com.completems.model.DynamoPost;
import com.completems.repository.CommentRepository;
import com.completems.repository.dynamo.DynamoCommentRepository;
import com.completems.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private DynamoCommentRepository dynamoCommentRepository;

    public CommentServiceImpl(CommentRepository commentRepository, DynamoCommentRepository dynamoCommentRepository) {
        this.commentRepository = commentRepository;
        this.dynamoCommentRepository = dynamoCommentRepository;
    }

    @Override
    public CommentDTO save(CommentDTO comment) {
        return CommentDTO.entityToDTO(dynamoCommentRepository.save(
                DynamoComment.builder()
                        .comment(comment.getComment())
                        .post(DynamoPost.builder().id(comment.getPost().getId()).build())
                        .build()));
    }

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
