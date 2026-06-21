package com.example.communityapplication.service;


import com.example.communityapplication.dto.CommentResponseDto;
import com.example.communityapplication.entity.Comments;
import com.example.communityapplication.entity.Users;
import com.example.communityapplication.repository.CommentsRepository;
import com.example.communityapplication.repository.PostsRepository;
import com.example.communityapplication.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Service
@Validated
@RequiredArgsConstructor
public class CommentService {
    private final CommentsRepository commentsRepository;
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    public CommentResponseDto createComment(Long postId, Long userId, String content, Date createdAt){
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        Comments comment = new Comments(
                postId,
                user.getNickname(),
               content,
                createdAt
        );
        commentsRepository.save(comment);
        return new CommentResponseDto(comment);
    }

//    @GetMapping
//    public List<CommentResponseDto> getComment(Long postId){
//        List<CommentResponseDto> commentList = new ArrayList<>();
//        CommentRepository.get().forEach((_, comment) -> {
//            if(comment.isCommentMatchingPost(postId))
//                commentList.add(new CommentResponseDto(comment));
//        });
//
//        return commentList;
//    }
//
//    @PatchMapping("/{commentId}")
//    public List<CommentResponseDto> patchComment(Long postId, Long commentId, CommentRequestDto request){
//        Comment comment = CommentRepository.get(commentId);
//        comment.changeContent(request.getContent());
//
//        return getComment(postId);
//    }
//
//    @DeleteMapping("/{commentId}")
//    public void deleteComment(Long postId, Long commentId){
//        CommentRepository.delete(commentId);
//    }
}
