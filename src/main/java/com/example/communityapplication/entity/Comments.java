package com.example.communityapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String author;
    private String content;
    private Date createdAt;

    public Comments(Long postId, String author, String content, Date createdAt){
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public boolean isCommentMatchingPost(Long postId){
        return this.postId.equals(postId);
    }

    public void changeContent(String content){
        this.content = content;
    }
}
