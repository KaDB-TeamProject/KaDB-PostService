package com.example.postservice.Entity.schedule;

import com.example.postservice.Entity.Post;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private String address;
    private String text;
    @ManyToOne
    @JoinColumn
    private Post post;
    @ManyToOne
    @JoinColumn
    private Schedule schedule;
}
