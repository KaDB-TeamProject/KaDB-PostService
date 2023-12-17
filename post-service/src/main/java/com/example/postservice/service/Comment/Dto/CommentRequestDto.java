package com.example.postservice.service.Comment.Dto;

import com.example.postservice.service.Comment.Entity.Comment;
import com.example.postservice.service.Post.Entity.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequestDto {
    private Long id;
    private String text;
    private Post post;
    // 유저 정보 필요
    // private User user;

    public CommentRequestDto(String text) {
        this.text = text;
    }

    public Comment toEntity(Post post){
        return Comment.builder().
                text(this.text).
                post(post).
                build();
    }
}
