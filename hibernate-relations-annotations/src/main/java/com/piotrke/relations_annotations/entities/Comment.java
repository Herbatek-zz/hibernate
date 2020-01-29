package com.piotrke.relations_annotations.entities;

import lombok.Data;

import javax.persistence.*;
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

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate;
    private String content;

    @PrePersist
    private void prePersist() {
        updatedDate = LocalDateTime.now();
    }
}
