package com.quest.service;

import com.quest.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveOneUser(User newUser);

    User getOneUser(Long userId);

    User updateOneUser(Long userId, User newUser);

    void deleteById(Long userId);

}
