package com.example.communityapplication.dto;

import com.example.communityapplication.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long commentId;
    private String author;
    private String content;
    private Date date;

    public CommentResponseDto(Comment comment){
        this.commentId = comment.getCommentId();
        this.author = comment.getAuthor();
        this.content = comment.getContent();
        this.date = comment.getDate();
    }
}
