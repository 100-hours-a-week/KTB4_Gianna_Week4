package com.example.communityapplication.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class Post {

    private Long postId;

    private Long userId;
    private String author;
    private Date date;

    private String title;
    private String content;
    private String file;

//    private Long like = 0L;
//    private Long view = 0L;

    public Post(Long postId, Long userId, String author, Date date, String title, String content, String file) {
        this.postId = postId;
        this.userId = userId;

        this.author = author;
        this.date = date;
        this.title = title;
        this.content = content;
        this.file = file == null ? null : file;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeFile(String file){ this.file = file;}
}
