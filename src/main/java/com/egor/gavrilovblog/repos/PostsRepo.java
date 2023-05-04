package com.egor.gavrilovblog.repos;

import com.egor.gavrilovblog.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Posts, Long> {
}
