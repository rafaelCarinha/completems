package com.completems.controller;

import com.completems.dto.CommentDTO;
import com.completems.model.Comment;
import com.completems.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    CommentDTO create(@RequestBody CommentDTO comment){
        return commentService.save(comment);
    }

    @GetMapping("/listAll")
    Iterable<Comment> listAll() {
        return commentService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Long id){
        commentService.deleteById(id);
    }

}
