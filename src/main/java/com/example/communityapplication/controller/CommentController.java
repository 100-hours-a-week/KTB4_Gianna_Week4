package com.example.communityapplication.controller;

import com.example.communityapplication.dto.CommentRequestDto;
import com.example.communityapplication.dto.CommentResponseDto;
import com.example.communityapplication.response.ApiResponse;
import com.example.communityapplication.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{userId}")
    public ApiResponse<CommentResponseDto> createComment(@PathVariable Long postId, @PathVariable Long userId, @Valid @RequestBody CommentRequestDto request){
        CommentResponseDto commentResponse = commentService.createComment(postId, userId,request);
        return ApiResponse.of("post_success", commentResponse);
    }

    @GetMapping
    public ApiResponse<List<CommentResponseDto>> getComment(@PathVariable Long postId){
        List<CommentResponseDto> commentResponse = commentService.getComment(postId);
        return ApiResponse.of("get_success", commentResponse);
    }

    @PatchMapping("/{commentId}")
    public ApiResponse<List<CommentResponseDto>> patchComment(@PathVariable Long postId, @PathVariable Long commentId, @Valid @RequestBody CommentRequestDto request){
        List<CommentResponseDto> commentResponse = commentService.patchComment(postId, commentId, request);
        return ApiResponse.of("patch_success", commentResponse);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long postId, @PathVariable Long commentId){
        commentService.deleteComment(postId,  commentId);
    }
}
