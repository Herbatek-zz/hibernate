package com.piotrke.hibernateexamples;


import com.piotrke.hibernateexamples.domain.Category;
import com.piotrke.hibernateexamples.domain.Comment;
import com.piotrke.hibernateexamples.domain.Meme;
import com.piotrke.hibernateexamples.domain.User;
import com.piotrke.hibernateexamples.respositories.CategoryRepository;
import com.piotrke.hibernateexamples.respositories.CommentRepository;
import com.piotrke.hibernateexamples.respositories.MemeRepository;
import com.piotrke.hibernateexamples.respositories.UserRepository;
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

    private User user;
    private Category category;
    private Meme meme;

    @Override
    public void run(String... args) {
        user = userRepository.save(new User("Magiczny Pioter"));
        category = categoryRepository.save(new Category("Doge"));
        meme = createMeme();
        createComment("hehe so funny meme");
        createComment("lul second comment");

        System.out.println("---------------------");

        userRepository.deleteById(user.getId());

        System.out.println("----------------------");
    }

    private Meme createMeme() {
        Meme meme = new Meme();
        meme.setName("Doge 01");
        meme.setImageUrl("some-url.com/doge.jpg");
        meme.setAuthor(user);
        meme.setCategory(category);
        return memeRepository.save(meme);
    }

    private void createComment(String content) {
        Comment comment1 = new Comment();
        comment1.setAuthor(user);
        comment1.setContent(content);
        comment1.setMeme(meme);
        commentRepository.save(comment1);
    }
}