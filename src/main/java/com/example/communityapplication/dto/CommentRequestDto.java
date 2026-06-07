package com.example.communityapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String content;
    private Date date;
}
