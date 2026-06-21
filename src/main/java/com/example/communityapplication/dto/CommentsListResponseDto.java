package com.example.communityapplication.dto;

import com.example.communityapplication.entity.Comments;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor

public class CommentsListResponseDto {
    private List<Comments> commentsList;

    public CommentsListResponseDto(List<Comments> commentsList){
        this.commentsList=commentsList;
    }
}
