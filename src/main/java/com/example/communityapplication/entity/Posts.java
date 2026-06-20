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
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String author;
    private Date createdAt;

    private String title;
    private String content;
    private String file;

    public Posts(Long userId, String author, Date createdAt, String title, String content, String file) {
        this.userId = userId;
        this.author = author;
        this.createdAt = createdAt;
        this.title = title;
        this.content = content;
        this.file = file;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeFile(String file){ this.file = file;}
}
