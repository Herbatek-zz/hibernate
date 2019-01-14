package com.piotrke.hibernateexamples.respositories;

import com.piotrke.hibernateexamples.domain.Meme;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemeRepository extends PagingAndSortingRepository<Meme, Long> {
}
