package com.piotrke.relations_annotations.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "meme", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;
}
