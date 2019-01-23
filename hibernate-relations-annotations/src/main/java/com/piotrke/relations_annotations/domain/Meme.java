package com.piotrke.relations_annotations.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ToString(exclude = "comments")
public class Meme {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String imageUrl;

    @ManyToOne
    private User author;

    @ManyToOne
    private Category category;

    @OrderBy("createdDate")
    @OneToMany(mappedBy = "meme", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private LocalDateTime createdDate = LocalDateTime.now();
}
