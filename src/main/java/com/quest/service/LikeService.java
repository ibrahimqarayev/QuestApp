package com.quest.service;

import com.quest.entity.Like;
import com.quest.dto.request.LikeCreateRequest;
import com.quest.dto.response.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAllLikesWithParam(Optional<Long> postId, Optional<Long> userId);

    Like getOneLikeById(Long likeId);


    Like createOneLike(LikeCreateRequest createLike);

    void deleteOneLikeById(Long likeId);
}
