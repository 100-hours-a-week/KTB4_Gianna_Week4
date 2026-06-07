package com.example.communityapplication.controller;

import com.example.communityapplication.dto.PostRequestDto;
import com.example.communityapplication.dto.PostResponseDto;
import com.example.communityapplication.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public PostResponseDto createPost(@PathVariable Long userId, @RequestBody PostRequestDto request) {
        return postService.createPost(userId, request);
    }

    //전체 조회
    @GetMapping
    public List<PostResponseDto> getPostList() {
        return postService.getPostList();
    }

    //상세 조회
    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    //게시글 수정
    @PatchMapping("/{postId}")
    public PostResponseDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDto request) {
        return postService.updatePost(postId, request);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
