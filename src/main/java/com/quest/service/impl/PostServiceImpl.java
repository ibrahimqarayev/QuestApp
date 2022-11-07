package com.quest.service.impl;
import com.quest.entity.Post;
import com.quest.entity.User;
import com.quest.repository.PostRepository;
import com.quest.request.PostCreateRequest;
import com.quest.request.PostUpdateRequest;
import com.quest.response.LikeResponse;
import com.quest.response.PostResponse;
import com.quest.service.LikeService;
import com.quest.service.PostService;
import com.quest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserService userService;
    private LikeService likeService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
@Autowired
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }

    @Override
    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> list;
        if (userId.isPresent()) {
            list = postRepository.findByUserId(userId.get());
        } else
            list = postRepository.findAll();
        return list.stream().map(post -> {
            List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(post.getId()));
            return new PostResponse(post, likes);
        }).collect(Collectors.toList());
    }

    @Override
    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post createOnePost(PostCreateRequest createPost) {
        User user = userService.getOneUserById(createPost.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(createPost.getId());
        toSave.setTitle(createPost.getTitle());
        toSave.setText(createPost.getText());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    @Override
    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post updateOnePost(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }


}
