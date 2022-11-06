package com.quest.request.post;

import lombok.Data;

@Data
public class PostCreateRequest {

    private Long id;

    private String text;

    private String title;

    private Long userId;


}
