package com.piotrke.hibernateexamples.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"memes", "comments"})
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Meme> memes;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    public User(String username) {
        this.username = username;
    }

    @PreRemove
    private void preRemove() {
        if (memes != null)
            memes.forEach(meme -> meme.setAuthor(null));
        if (comments != null)
            comments.forEach(comment -> comment.setAuthor(null));
    }

}
