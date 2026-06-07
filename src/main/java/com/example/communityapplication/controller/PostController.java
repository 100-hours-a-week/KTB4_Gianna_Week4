package com.example.communityapplication.controller;

import com.example.communityapplication.dto.PostRequestDto;
import com.example.communityapplication.dto.PostResponseDto;
import com.example.communityapplication.entity.Post;
import com.example.communityapplication.repository.PostRepository;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private Long lastId = 0L;

    @PostMapping("/{userId}")
    public PostResponseDto createPost(
            @PathVariable Long userId,
            @RequestBody PostRequestDto request
    ) {
        String author = UserRepository.findUserName(userId);
        lastId++;

        Post post = new Post(
                lastId,
                userId,
                author,
                request.getDate(),
                request.getTitle(),
                request.getContent(),
                request.getFile()
        );
        PostRepository.save(lastId, post);
        return new PostResponseDto(post);
    }

    //전체 조회
    @GetMapping
    public List<PostResponseDto> getPostList() {
        List<PostResponseDto> list = new ArrayList<>();
        PostRepository.get().forEach((_, post ) -> list.add(new PostResponseDto(post)));
        return list;
    }

    //상세 조회
    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId) {
        Post post = PostRepository.get(postId);
        return new PostResponseDto(post);
    }

    //게시글 수정
    @PatchMapping("/{postId}")
    public PostResponseDto updatePost(
            @PathVariable Long postId,
            @RequestBody PostRequestDto request
    ) {
        Post post = PostRepository.get(postId);

        post.changeTitle(request.getTitle());
        post.changeContent(request.getContent());
        post.changeFile(request.getFile());

        return new PostResponseDto(post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        PostRepository.delete(postId);
    }
}
