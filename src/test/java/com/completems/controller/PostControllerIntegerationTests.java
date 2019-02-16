package com.completems.controller;

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
public class PostControllerIntegerationTests {

    @Autowired
    PostController postController;

    @Test
    public void testCreateReadDelete() {
        Post post = new Post("Name", "Tittle", "Content", LocalDateTime.now(), null);

        Post postResult = postController.create(post);

        Iterable<Post> posts = postController.listAll();
        Assertions.assertThat(posts).first().hasFieldOrPropertyWithValue("tittle", "Tittle");

        postController.deleteById(postResult.getId());
        Assertions.assertThat(postController.listAll()).isEmpty();

    }
}
