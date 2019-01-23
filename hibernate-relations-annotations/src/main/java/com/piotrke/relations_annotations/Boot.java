package com.piotrke.relations_annotations;


import com.piotrke.relations_annotations.domain.Category;
import com.piotrke.relations_annotations.domain.Comment;
import com.piotrke.relations_annotations.domain.Meme;
import com.piotrke.relations_annotations.domain.User;
import com.piotrke.relations_annotations.respositories.CategoryRepository;
import com.piotrke.relations_annotations.respositories.CommentRepository;
import com.piotrke.relations_annotations.respositories.MemeRepository;
import com.piotrke.relations_annotations.respositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Boot implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CommentRepository commentRepository;
    private final MemeRepository memeRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws InterruptedException, NotFound {
        User user = userRepository.save(new User("Magiczny Pioter"));
        Category category = categoryRepository.save(new Category("Doge"));
        Meme meme = createMeme(user, category);

        Comment comment1 = createComment(user, meme, "hehe so funny meme");
        Thread.sleep(3000);
        Comment comment2 = createComment(user, meme, "first comment");

        Thread.sleep(3000);

        comment2.setContent("oh... I was second :<");
        commentRepository.save(comment2);

        memeRepository.findByIdWithComments(meme.getId()).get().getComments().forEach(System.out::println);

        System.out.println(memeRepository.findNumberOfCommentsForParticularMeme(meme.getId()));
        System.out.println(memeRepository.findNumberOfCommentsForParticularMeme(22));

        userRepository.deleteById(user.getId());

    }

    private Meme createMeme(User user, Category category) {
        Meme meme = new Meme();
        meme.setName("Doge 01");
        meme.setImageUrl("some-url.com/doge.jpg");
        meme.setAuthor(user);
        meme.setCategory(category);
        return memeRepository.save(meme);
    }

    private Comment createComment(User user, Meme meme, String content) {
        Comment comment = new Comment();
        comment.setAuthor(user);
        comment.setContent(content);
        comment.setMeme(meme);
        return commentRepository.save(comment);
    }
}