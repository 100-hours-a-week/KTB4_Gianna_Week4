package com.example.communityapplication.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class Comment {
    private Long commentId;
    private Long postId;
    private String author;
    private String content;
    private Date date;

    public Comment(Long commentId, Long postId, String author, String content,Date date){
        this.commentId = commentId;
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public boolean isCommentMatchingPost(Long postId){
        return this.postId.equals(postId);
    }

    public void changeContent(String content){
        this.content = content;
    }
}
