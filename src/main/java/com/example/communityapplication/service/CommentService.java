package com.example.communityapplication.service;

import com.example.communityapplication.dto.CommentRequestDto;
import com.example.communityapplication.dto.CommentResponseDto;
import com.example.communityapplication.entity.Comment;
import com.example.communityapplication.entity.User;
import com.example.communityapplication.repository.CommentRepository;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    public CommentResponseDto createComment(Long postId,  Long userId, CommentRequestDto request){
        User user = UserRepository.getUser(userId);
        String author = user.getNickname();
        Long curId = CommentRepository.getCurId();
        Comment comment = new Comment(
                curId,
                postId,
                author,
                request.getContent(),
                request.getDate()
        );
        CommentRepository.save(curId, comment);
        return new CommentResponseDto(comment);
    }

    @GetMapping
    public List<CommentResponseDto> getComment(Long postId){
        List<CommentResponseDto> commentList = new ArrayList<>();
        CommentRepository.get().forEach((_, comment) -> {
            if(comment.isCommentMatchingPost(postId))
                commentList.add(new CommentResponseDto(comment));
        });

        return commentList;
    }

    @PatchMapping("/{commentId}")
    public List<CommentResponseDto> patchComment(Long postId, Long commentId, CommentRequestDto request){
        Comment comment = CommentRepository.get(commentId);
        comment.changeContent(request.getContent());

        return getComment(postId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(Long postId, Long commentId){
        CommentRepository.delete(commentId);
    }
}
