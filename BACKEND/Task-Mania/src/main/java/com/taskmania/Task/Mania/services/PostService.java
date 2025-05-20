package com.example.Backend.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Backend.model.Comment;
import com.example.Backend.model.Like;
import com.example.Backend.model.Post;
import com.example.Backend.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private NotificationService notificationService;

    public Post createPost(Post post) {
        if (post.getUserId() == null || post.getUserId().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (post.getUserName() == null || post.getUserName().isEmpty()) {
            post.setUserName("Unknown User");
        }
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());
        post.setLikes(new ArrayList<>());
        post.setComments(new ArrayList<>());
        return postRepository.save(post);
    }

    



    
}
