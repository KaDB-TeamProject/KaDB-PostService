package com.example.postservice.service.Comment.Entity;

import com.example.postservice.service.Post.Entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String text;
    @Column
    private Long likes;
    // comment를 단 유저 정보 추가 필요
    // private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Post post;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CommentLike> commentLikes;
    @Builder
    public Comment(String text, Post post) {
        this.text = text;
        this.post = post;
    }
    public void editComment(String text, Post post){
        this.text = text;
        this.post = post;
    }
}