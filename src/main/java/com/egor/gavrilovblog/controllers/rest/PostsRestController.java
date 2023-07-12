package com.egor.gavrilovblog.controllers.rest;

import com.egor.gavrilovblog.entities.Posts;
import com.egor.gavrilovblog.service.PostsService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsRestController {
    private final PostsService service;

    @GetMapping("/rest")
    public List<Posts> all() {
        return service.findAll();
    }

    @PostMapping("/rest/publish")
    public Posts publish(@RequestBody Posts posts) {
        return service.create(posts);
    }

    @DeleteMapping("/rest/delete/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PutMapping("/rest/modify/{id}")
    public Posts modify(@PathVariable long id, @RequestBody Posts posts) {
        return service.modify(id, posts);
    }
}
