package com.quest.entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String userName;
    private String password;
}
