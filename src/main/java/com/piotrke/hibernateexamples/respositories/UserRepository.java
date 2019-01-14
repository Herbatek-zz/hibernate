package com.piotrke.hibernateexamples.respositories;

import com.piotrke.hibernateexamples.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
