package com.completems.service;

import com.completems.model.Post;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceJPATests {

    @Autowired
    PostService postService;

    @Test
    public void testCreateReadDelete() {
        Post post = new Post("Name", "Title", "Content", LocalDateTime.now());

        Post postResult = postService.save(post);

        Iterable<Post> posts = postService.findAll();
        Assertions.assertThat(posts).first().hasFieldOrPropertyWithValue("title", "Title");

        postService.deleteById(postResult.getId());
        Assertions.assertThat(postService.findAll()).isEmpty();

    }
}
