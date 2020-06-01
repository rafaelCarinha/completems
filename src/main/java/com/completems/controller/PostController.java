package com.completems.controller;

import com.completems.dto.PostDTO;
import com.completems.model.Post;
import com.completems.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    PostDTO create(@RequestBody PostDTO post){

        return postService.save(post);
    }

    @PutMapping("/update")
    PostDTO update(@RequestBody PostDTO post){

        return postService.update(post);
    }

    @GetMapping("/listAll")
    Iterable<Post> listAll() {
        return postService.findAll();
    }

    @GetMapping("/findById")
    Post findById(@RequestParam Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Long id){
        postService.deleteById(id);
    }

}
