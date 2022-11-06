package com.quest.service;
import com.quest.entity.Comment;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getCommentWithParam(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId);

}
