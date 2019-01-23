package com.piotrke.relations_annotations.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
