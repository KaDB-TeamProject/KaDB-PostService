package com.example.postservice.Entity.comment;

import com.example.postservice.Entity.Post;
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
