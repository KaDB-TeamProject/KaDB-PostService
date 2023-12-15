package com.example.postservice.service.Comment.Entity;

import com.example.postservice.service.Post.Entity.Post;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    @JoinColumn
    private Post post;
}
