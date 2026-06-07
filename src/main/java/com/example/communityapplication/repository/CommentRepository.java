package com.example.communityapplication.repository;

import com.example.communityapplication.entity.Comment;

import java.util.HashMap;
import java.util.Map;

public class CommentRepository {
    private static Long curId = 1L;
    private static final Map<Long, Comment> commentRepository = new HashMap<>();

    public static Long getCurId(){
        return ++curId;
    }
    public static void save (Long commentId, Comment comment ){
        commentRepository.put(commentId, comment);
    }
    public static Map<Long, Comment> get(){ return commentRepository; }
    public static Comment get(Long commentId){ return  commentRepository.get(commentId); }
    public static void delete(Long commentId){ commentRepository.remove(commentId);}
}
