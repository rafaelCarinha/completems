package com.completems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Size(min=1)
    private String name;

    @Size(min=1)
    private String title;

    @Size(min=1)
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public Post(String name, String title, String content, LocalDateTime now) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.createdAt = now;
    }
}
