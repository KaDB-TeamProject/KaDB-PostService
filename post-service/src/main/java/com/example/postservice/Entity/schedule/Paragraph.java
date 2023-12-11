package com.example.postservice.Entity.schedule;

import com.example.postservice.Entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Paragraph(String place, String address, String text, Post post, Schedule schedule) {
        this.place = place;
        this.address = address;
        this.text = text;
        this.post = post;
        this.schedule = schedule;
    }
}
