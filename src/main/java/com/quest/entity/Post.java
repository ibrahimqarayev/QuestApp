package com.quest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    private Long id;
    private Long userId;
    private String title;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

}
