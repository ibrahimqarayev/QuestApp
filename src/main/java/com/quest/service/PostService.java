package com.quest.service;

import com.quest.entity.Post;
import com.quest.dto.request.PostCreateRequest;
import com.quest.dto.request.PostUpdateRequest;
import com.quest.dto.response.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostResponse> getAllPosts(Optional<Long> userId);

    Post getOnePostById(Long postId);

    Post createOnePost(PostCreateRequest createPost);

    void deleteOnePostById(Long postId);

    Post updateOnePost(Long postId, PostUpdateRequest updatePost);
}
