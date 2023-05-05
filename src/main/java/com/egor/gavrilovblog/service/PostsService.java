package com.egor.gavrilovblog.service;

import com.egor.gavrilovblog.entities.Posts;
import com.egor.gavrilovblog.repos.PostsRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
    private final PostsRepo repo;

    public PostsService(PostsRepo repo) {
        this.repo = repo;
    }

    public List<Posts> findAll() {
        return repo.findAll();
    }

    public List<Posts> findLatest5() {
        return repo.findLatest5Posts(PageRequest.of(0, 5));
    }

    public Posts create(Posts posts) {
        return repo.save(posts);
    }
}
