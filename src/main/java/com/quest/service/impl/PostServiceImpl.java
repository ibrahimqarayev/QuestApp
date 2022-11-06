package com.quest.service.impl;

import com.quest.entity.Post;
import com.quest.entity.User;
import com.quest.repository.PostRepository;
import com.quest.request.PostCreateRequest;
import com.quest.request.PostUpdateRequest;
import com.quest.service.PostService;
import com.quest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
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

    @Override
    public Post createOnePost(PostCreateRequest createPost) {
        User user = userService.getOneUser(createPost.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(createPost.getId());
        toSave.setTitle(createPost.getTitle());
        toSave.setText(createPost.getText());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    @Override
    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }


}
