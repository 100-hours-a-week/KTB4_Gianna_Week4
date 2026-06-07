package com.example.communityapplication.controller;

import com.example.communityapplication.dto.CommentRequestDto;
import com.example.communityapplication.dto.CommentResponseDto;
import com.example.communityapplication.entity.Comment;
import com.example.communityapplication.entity.User;
import com.example.communityapplication.repository.CommentRepository;
import com.example.communityapplication.repository.UserRepository;
import com.example.communityapplication.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{userId}")
    public CommentResponseDto createComment(@PathVariable Long postId, @PathVariable Long userId, @RequestBody CommentRequestDto request){
        return commentService.createComment(postId, userId,request);
    }

    @GetMapping
    public List<CommentResponseDto> getComment(@PathVariable Long postId){
        return commentService.getComment(postId);
    }

    @PatchMapping("/{commentId}")
    public List<CommentResponseDto> patchComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentRequestDto request){
        return commentService.patchComment(postId, commentId, request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long postId, @PathVariable Long commentId){
        commentService.deleteComment(postId,  commentId);
    }
}
