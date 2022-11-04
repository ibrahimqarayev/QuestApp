package com.quest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    private Long id;

    private Long postId;

    private Long userId;

    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
