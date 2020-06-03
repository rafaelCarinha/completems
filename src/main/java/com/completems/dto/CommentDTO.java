package com.completems.dto;

import com.completems.model.DynamoComment;
import com.completems.model.DynamoPost;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {

    private String id;

    private String comment;

    @JsonBackReference
    PostDTO post;

    public static CommentDTO entityToDTO(DynamoComment comment){
        return CommentDTO.builder().
                id(comment.getId())
                .comment(comment.getComment())
                .build();
    }

}
