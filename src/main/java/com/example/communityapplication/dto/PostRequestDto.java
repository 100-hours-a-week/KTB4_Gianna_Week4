package com.example.communityapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private Date date;
    private String title;
    private String content;
    private String file;
}