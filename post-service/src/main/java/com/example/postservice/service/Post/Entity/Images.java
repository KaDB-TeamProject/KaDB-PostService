package com.example.postservice.service.Post.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Paragraph paragraph;
    @Column(nullable = false)
    private String url;

    @Builder
    public Images(Paragraph paragraph, String url) {
        this.paragraph = paragraph;
        this.url = url;
    }
}
