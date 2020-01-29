package com.piotrke.relations_annotations;


import com.piotrke.relations_annotations.entities.Category;
import com.piotrke.relations_annotations.entities.Comment;
import com.piotrke.relations_annotations.entities.Meme;
import com.piotrke.relations_annotations.entities.User;
import com.piotrke.relations_annotations.respositories.CategoryRepository;
import com.piotrke.relations_annotations.respositories.CommentRepository;
import com.piotrke.relations_annotations.respositories.MemeRepository;
import com.piotrke.relations_annotations.respositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Boot implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CommentRepository commentRepository;
    private final MemeRepository memeRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws InterruptedException {
        User magicznyPioter = userRepository.save(new User("Magiczny Pioter"));
        Category category = categoryRepository.save(new Category("Doge"));
        Meme meme = createMeme(magicznyPioter, category);

        Comment comment1 = createComment(magicznyPioter, meme, "hehe so funny meme");
        Thread.sleep(3000);
        Comment comment2 = createComment(magicznyPioter, meme, "first comment");

        Thread.sleep(3000);

        comment2.setContent("oh... I was second :<");
        commentRepository.save(comment2);

        memeRepository.findByIdWithComments(meme.getId())
                .ifPresent(m -> m.getComments().forEach(System.out::println));

        System.out.println(memeRepository.findNumberOfCommentsForParticularMeme(meme.getId()));
        System.out.println(memeRepository.findNumberOfCommentsForParticularMeme(22));

        userRepository.deleteById(magicznyPioter.getId());

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