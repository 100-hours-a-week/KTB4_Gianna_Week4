package com.example.communityapplication.service;

import com.example.communityapplication.dto.PostRequestDto;
import com.example.communityapplication.dto.PostResponseDto;
import com.example.communityapplication.entity.Post;
import com.example.communityapplication.entity.User;
import com.example.communityapplication.repository.PostRepository;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    public PostResponseDto createPost(Long userId, PostRequestDto request) {
        User user = UserRepository.getUser(userId);
        String author = user.getNickname();
        Long curId = PostRepository.getCurId();
        Post post = new Post(
                curId,
                userId,
                author,
                request.getDate(),
                request.getTitle(),
                request.getContent(),
                request.getFile()
        );
        PostRepository.save(curId, post);
        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPostList() {
        List<PostResponseDto> list = new ArrayList<>();
        PostRepository.get().forEach((_, post ) -> list.add(new PostResponseDto(post)));
        return list;
    }

    public PostResponseDto getPost(Long postId) {
        Post post = PostRepository.get(postId);
        return new PostResponseDto(post);
    }

    public PostResponseDto updatePost( Long postId, PostRequestDto request) {
        Post post = PostRepository.get(postId);

        post.changeTitle(request.getTitle());
        post.changeContent(request.getContent());
        post.changeFile(request.getFile());

        return new PostResponseDto(post);
    }


    public void deletePost(Long postId) {
        PostRepository.delete(postId);
    }
}
