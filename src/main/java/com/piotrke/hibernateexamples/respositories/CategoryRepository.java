package com.piotrke.hibernateexamples.respositories;

import com.piotrke.hibernateexamples.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
