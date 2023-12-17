package com.example.postservice.service.Comment.Entity;

import com.example.postservice.service.Post.Entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Long User_Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Post post;
    @Builder
    public Comment(String text, Long user_Id, Post post) {
        this.text = text;
        User_Id = user_Id;
        this.post = post;
    }
}
