package com.completems.controller;

import com.completems.model.Post;
import com.completems.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    Post create(@RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping("/listAll")
    Iterable<Post> listAll() {
        return postService.findAll();
    }

    @DeleteMapping("/delete")
    void delete(@RequestBody Post post){
        postService.delete(post);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@RequestParam Integer id){
        postService.deleteById(id);
    }

}
