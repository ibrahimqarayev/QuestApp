package com.quest.repository;

import com.quest.entity.Like;
import com.quest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {


    List<Like> findByPostIdAndUserId(Optional<Long> postId, Optional<Long> userId);

    List<Like> findByPostId(Long aLong);

    List<Like> findByUserId(Long aLong);
}

