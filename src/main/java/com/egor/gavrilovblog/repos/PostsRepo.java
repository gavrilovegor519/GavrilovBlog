package com.egor.gavrilovblog.repos;

import com.egor.gavrilovblog.entities.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepo extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.date DESC")
    List<Posts> findLatest5Posts(Pageable pageable);

    void deleteById(long id);

    Posts getById(long id);
}
