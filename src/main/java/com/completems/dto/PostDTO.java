package com.completems.dto;

import com.completems.model.DynamoPost;
import com.completems.model.Post;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PostDTO {

    private String id;

    private String name;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonManagedReference
    private List<CommentDTO> comments;

    public PostDTO(String name, String title, String content, LocalDateTime now) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.createdAt = now;
    }

    public PostDTO(String id, String name, String title, String content, LocalDateTime now, LocalDateTime updatedAt, Collection<CommentDTO> comments) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.createdAt = now;
        this.updatedAt = updatedAt;
        this.comments = (ArrayList) comments;
    }

    public static PostDTO entityToDTO(Post post){
        return PostDTO.builder().
                id(post.getId())
                .name(post.getName())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static PostDTO entityToDTO(DynamoPost post){
        return PostDTO.builder().
                id(post.getId())
                .name(post.getName())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

}
