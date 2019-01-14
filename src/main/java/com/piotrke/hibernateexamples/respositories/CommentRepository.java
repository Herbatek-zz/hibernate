package com.piotrke.hibernateexamples.respositories;

import com.piotrke.hibernateexamples.domain.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
