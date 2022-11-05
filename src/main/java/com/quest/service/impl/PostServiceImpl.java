package com.quest.service.impl;

import com.quest.entity.Post;
import com.quest.repository.PostRepository;
import com.quest.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    @Override
    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


}
