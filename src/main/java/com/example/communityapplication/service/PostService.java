package com.example.communityapplication.service;

import com.example.communityapplication.dto.PostResponseDto;
import com.example.communityapplication.entity.Posts;
import com.example.communityapplication.entity.Users;
import com.example.communityapplication.repository.PostsRepository;
import com.example.communityapplication.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Service
@Validated
@RequiredArgsConstructor
public class PostService {
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    public PostResponseDto createPost(Long userId, Date date, String title, String content, String file) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        String author = user.getNickname();
        Posts post = new Posts(
                userId,
                author,
                date,
                title,
                content,
                file
        );
        postsRepository.save(post);
        return new PostResponseDto(post);
    }
//
//    public List<PostResponseDto> getPostList() {
//        List<PostResponseDto> list = new ArrayList<>();
//        PostRepository.get().forEach((_, post ) -> list.add(new PostResponseDto(post)));
//        return list;
//    }
//
//    public PostResponseDto getPost(Long postId) {
//        Post post = PostRepository.get(postId);
//        return new PostResponseDto(post);
//    }
//
//    public PostResponseDto updatePost( Long postId, PostRequestDto request) {
//        Post post = PostRepository.get(postId);
//
//        post.changeTitle(request.getTitle());
//        post.changeContent(request.getContent());
//        post.changeFile(request.getFile());
//
//        return new PostResponseDto(post);
//    }
//
//
//    public void deletePost(Long postId) {
//        PostRepository.delete(postId);
//    }
}
