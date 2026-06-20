package com.example.communityapplication.dto;

import com.example.communityapplication.entity.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long postId;
    private Long userId;
    private String author;
    private Date date;

    private String title;
    private String content;
    private String file;

    public PostResponseDto(Posts posts) {
        this.postId = posts.getPostId();
        this.userId= posts.getUserId();
        this.author = posts.getAuthor();
        this.date = posts.getDate();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.file = posts.getFile();
    }
}
