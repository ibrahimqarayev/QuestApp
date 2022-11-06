package com.quest.service.impl;

import com.quest.entity.User;
import com.quest.repository.UserRepository;
import com.quest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getOneUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user;
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
