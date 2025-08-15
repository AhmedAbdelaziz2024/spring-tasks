package com.springboot.controller;

import com.springboot.dto.PostDTO;
import com.springboot.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {

    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostDTO create(@Valid @RequestBody PostDTO dto) {
        return postService.createPost(dto);
    }

    @GetMapping("/{id}")
    public PostDTO get(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping
    public List<PostDTO> getAll() {
        return postService.getAllPosts();
    }

    @PutMapping("/{id}")
    public PostDTO update(@PathVariable Long id, @Valid @RequestBody PostDTO dto) {
        return postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @GetMapping("/account/{accountId}")
    public List<PostDTO> getPostsByAccount(@PathVariable Long accountId) {
        return postService.getPostsByAccountId(accountId);
    }

    @GetMapping("/postsWithUsers")
    public List<PostDTO> getPostsWithUsers() {
        return postService.getAllPostsWithUsers();
    }

    @GetMapping("/postWithUsers/{id}")
    public PostDTO getPostWithUser(@PathVariable Long id) {
        return postService.getPostWithUser(id);
    }
}
