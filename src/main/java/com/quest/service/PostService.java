package com.quest.service;

import com.quest.entity.Post;
import com.quest.request.post.PostCreateRequest;
import com.quest.request.post.PostUpdateRequest;
import com.quest.response.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostResponse> getAllPosts(Optional<Long> userId);

    Post getOnePostById(Long postId);

    Post createOnePost(PostCreateRequest createPost);

    void deleteOnePostById(Long postId);

    Post updateOnePost(Long postId, PostUpdateRequest updatePost);
}
