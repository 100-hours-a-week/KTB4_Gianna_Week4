package com.example.communityapplication.dto;

import com.example.communityapplication.entity.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostsListResponseDto {
    private List<Posts> postList;
    public PostsListResponseDto(List<Posts> postList){
        this.postList=postList;
    }
}
