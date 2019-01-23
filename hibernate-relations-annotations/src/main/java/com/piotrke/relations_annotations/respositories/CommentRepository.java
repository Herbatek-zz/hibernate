package com.piotrke.relations_annotations.respositories;

import com.piotrke.relations_annotations.domain.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
