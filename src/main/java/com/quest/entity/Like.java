package com.quest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_like")
@Data
public class Like {
    @Id
    private Long id;
    private Long postId;
    private Long userId;
}
