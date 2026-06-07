package com.example.communityapplication.controller;

import com.example.communityapplication.dto.CommentRequestDto;
import com.example.communityapplication.dto.CommentResponseDto;
import com.example.communityapplication.entity.Comment;
import com.example.communityapplication.repository.CommentRepository;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private Long lastId = 0L;

    @PostMapping("/{userId}")
    public CommentResponseDto createComment(@PathVariable Long postId, @PathVariable Long userId, @RequestBody CommentRequestDto request){
        String author = UserRepository.findUserName(userId);
        lastId++;
        Comment comment = new Comment(
                lastId,
                postId,
                author,
                request.getContent(),
                request.getDate()
        );
        CommentRepository.save(lastId, comment);
        return new CommentResponseDto(comment);
    }

    @GetMapping
    public List<CommentResponseDto> getComment(@PathVariable Long postId){
        List<CommentResponseDto> commentList = new ArrayList<>();
        CommentRepository.get().forEach((_, comment) -> {
            if(comment.isCommentMatchingPost(postId))
                commentList.add(new CommentResponseDto(comment));
        });

        return commentList;
    }

    @PatchMapping("/{commentId}")
    public List<CommentResponseDto> patchComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentRequestDto request){
        Comment comment = CommentRepository.get(commentId);
        comment.changeContent(request.getContent());

        return getComment(postId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long postId, @PathVariable Long commentId){
        CommentRepository.delete(commentId);
    }
}
