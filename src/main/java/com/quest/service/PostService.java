package com.quest.service;

import com.quest.entity.Post;
import com.quest.request.PostCreateRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAllPosts(Optional<Long> userId);

    Post getOnePostById(Long postId);

    Post createOnePost(PostCreateRequest postCreateRequest);
}
