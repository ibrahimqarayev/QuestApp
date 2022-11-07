package com.quest.request.like;

import lombok.Data;

@Data
public class LikeCreateRequest {
    private Long id;
    private Long postId;
    private Long userId;
}
