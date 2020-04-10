package com.completems.service;

import com.completems.model.Post;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PostServiceJPATests {

    @Autowired
    PostService postService;

    @Test
    public void testCreateReadDelete() {
        Post post = new Post("Name", "Tittle", "Content", LocalDateTime.now(), null);

        Post postResult = postService.save(post);

        Iterable<Post> posts = postService.findAll();
        Assertions.assertThat(posts).first().hasFieldOrPropertyWithValue("tittle", "Tittle");

        postService.deleteById(postResult.getId());
        Assertions.assertThat(postService.findAll()).isEmpty();

    }
}
