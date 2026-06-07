package com.example.communityapplication.dto;

import com.example.communityapplication.entity.Post;
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

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.userId= post.getUserId();
        this.author = post.getAuthor();
        this.date = post.getDate();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.file = post.getFile();
    }
}
