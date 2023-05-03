package com.egor.gavrilovblog.repos;

import com.egor.gavrilovblog.entities.Posts;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostsRepo extends PagingAndSortingRepository<Posts, Long> {
    Posts findById(long id);
}
