package com.quest.service.impl;

import com.quest.entity.Comment;
import com.quest.entity.Post;
import com.quest.entity.User;
import com.quest.repository.CommentRepository;
import com.quest.request.comment.CommentCreateRequest;
import com.quest.request.comment.CommentUpdateRequest;
import com.quest.service.CommentService;
import com.quest.service.PostService;
import com.quest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Comment> getCommentWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else
            return commentRepository.findAll();
    }

    @Override
    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment createOneComment(CommentCreateRequest createComment) {
        User user = userService.getOneUserById(createComment.getUserId());
        Post post = postService.getOnePostById(createComment.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(createComment.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(createComment.getText());
            return commentRepository.save(commentToSave);
        } else
            return null;
    }

    @Override
    public Comment updateOneComment(Long commentId, CommentUpdateRequest updateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(updateRequest.getText());
            return commentRepository.save(commentToUpdate);
        } else
            return null;
    }

    @Override
    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}
