package com.springboot.service.serviceImpl;

import com.springboot.dto.PostDTO;
import com.springboot.mapper.PostMapper;
import com.springboot.model.Account;
import com.springboot.model.Post;
import com.springboot.repository.AccountRepo;
import com.springboot.repository.PostRepo;
import com.springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    private  PostRepo postRepository;
    private  AccountRepo accountRepository;
    private  PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepo postRepository, AccountRepo accountRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDTO createPost(PostDTO dto) {
        Post post = postMapper.toEntity(dto);

        if (dto.getAccountId() != null) {
            Account account = accountRepository.findById(dto.getAccountId())
                    .orElseThrow(() -> new RuntimeException("Account not found"));
            post.setAccount(account);
        }

        return postMapper.toDTO(postRepository.save(post));
    }

    @Override
    public PostDTO getPost(Long id) {
        return postRepository.findById(id)
                .map(postMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toDTO)
                .toList();
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());

        if (dto.getAccountId() != null) {
            Account account = accountRepository.findById(dto.getAccountId())
                    .orElseThrow(() -> new RuntimeException("Account not found"));
            post.setAccount(account);
        }

        return postMapper.toDTO(postRepository.save(post));
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDTO> getPostsByAccountId(Long accountId) {
        return postRepository.findAll()
                .stream()
                .filter(post -> post.getAccount() != null && post.getAccount().getId().equals(accountId))
                .map(postMapper::toDTO)
                .toList();
    }

    @Override
    public List<PostDTO> getAllPostsWithUsers() {
        return getAllPosts();
    }

    @Override
    public PostDTO getPostWithUser(Long id) {
        return getPost(id);
    }
}
