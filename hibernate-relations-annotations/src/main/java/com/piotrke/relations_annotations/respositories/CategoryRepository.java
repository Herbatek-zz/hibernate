package com.piotrke.relations_annotations.respositories;

import com.piotrke.relations_annotations.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
