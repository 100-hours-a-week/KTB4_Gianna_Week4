package com.example.communityapplication.controller;

import com.example.communityapplication.dto.PostRequestDto;
import com.example.communityapplication.dto.PostResponseDto;
import com.example.communityapplication.response.ApiResponse;
import com.example.communityapplication.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public ApiResponse<PostResponseDto> createPost(@PathVariable Long userId, @Valid @RequestBody PostRequestDto request) {
        PostResponseDto postResponse = postService.createPost(userId, request);
        return ApiResponse.of("post_success", postResponse);
    }

    //전체 조회
    @GetMapping
    public ApiResponse<List<PostResponseDto>> getPostList() {
        List<PostResponseDto> postResponse = postService.getPostList();
        return ApiResponse.of("get_success", postResponse);
    }

    //상세 조회
    @GetMapping("/{postId}")
    public ApiResponse<PostResponseDto> getPost(@PathVariable Long postId) {
        PostResponseDto postResponse = postService.getPost(postId);
        return ApiResponse.of("get_success", postResponse);
    }

    //게시글 수정
    @PatchMapping("/{postId}")
    public ApiResponse<PostResponseDto> updatePost(@PathVariable Long postId, @Valid  @RequestBody PostRequestDto request) {
        PostResponseDto postResponse = postService.updatePost(postId, request);
        return ApiResponse.of("patch_success", postResponse);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
