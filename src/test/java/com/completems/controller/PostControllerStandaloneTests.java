package com.completems.controller;

import com.completems.model.Post;
import com.completems.service.PostService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerStandaloneTests {

    @MockBean
    PostService postService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception {
        Post post = new Post("Name", "Tittle", "Content", LocalDateTime.now(), null);
        List<Post> posts = Arrays.asList(post);

        Mockito.when(postService.findAll()).thenReturn(posts);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/blog/api/v1/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].tittle", Matchers.is("Tittle")));
    }
}
