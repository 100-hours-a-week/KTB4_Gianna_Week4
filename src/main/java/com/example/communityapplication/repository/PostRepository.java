package com.example.communityapplication.repository;

import com.example.communityapplication.entity.Post;
import java.util.HashMap;
import java.util.Map;

public class PostRepository {
    private static final Map<Long, Post> postRepository = new HashMap<>();
    public static void save (Long postId, Post post){
        postRepository.put(postId, post);
    }
    public static Map<Long, Post> get(){
       return postRepository;
    }
    public static Post get(Long postId){
        return postRepository.get(postId);
    }
    public static void delete(Long postId){
        postRepository.remove(postId);
    }
}
