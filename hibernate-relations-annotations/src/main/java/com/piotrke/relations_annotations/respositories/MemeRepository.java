package com.piotrke.relations_annotations.respositories;

import com.piotrke.relations_annotations.domain.Meme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MemeRepository extends PagingAndSortingRepository<Meme, Long> {

    @Query("SELECT COUNT(c.id) FROM Comment c WHERE c.meme.id = :memeId")
    long findNumberOfCommentsForParticularMeme(long memeId);

    @Query("SELECT m FROM Meme m JOIN FETCH m.comments WHERE m.id = :memeId")
    Optional<Meme> findByIdWithComments(long memeId);

}
