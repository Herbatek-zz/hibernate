package com.piotrke.relations_annotations.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User author;

    @ManyToOne
    private Meme meme;

    private LocalDateTime dateTime = LocalDateTime.now();

    private String content;
}
