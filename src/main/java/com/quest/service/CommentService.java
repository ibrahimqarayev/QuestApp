package com.quest.service;
import com.quest.entity.Comment;
import com.quest.request.CommentCreateRequest;
import com.quest.request.CommentUpdateRequest;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getCommentWithParam(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId);

    Comment getOneCommentById(Long commentId);

    Comment createOneComment(CommentCreateRequest createComment);

    Comment updateOneComment(Long commentId, CommentUpdateRequest updateRequest);

    void deleteOneCommentById(Long commentId);
}
