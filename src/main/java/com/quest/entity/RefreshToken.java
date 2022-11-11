package com.quest.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="refresh_token")
@Data
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

}
