package com.springboot.service;

import com.springboot.dto.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO dto);
    PostDTO getPost(Long id);
    List<PostDTO> getAllPosts();
    PostDTO updatePost(Long id, PostDTO dto);
    void deletePost(Long id);

    List<PostDTO> getPostsByAccountId(Long accountId);
    List<PostDTO> getAllPostsWithUsers();
    PostDTO getPostWithUser(Long id);
}
