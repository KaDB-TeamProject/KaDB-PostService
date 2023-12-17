package com.example.postservice.service.Post.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Paragraph paragraph;
    @Column(nullable = false)
    private String url;
    @Column
    private String originalName;

    @Builder
    public Images(Paragraph paragraph, String url, String originalName) {
        this.paragraph = paragraph;
        this.url = url;
        this.originalName = originalName;
    }
    public void editImages(Paragraph paragraph, String url, String originalName) {
        this.paragraph = paragraph;
        this.url = url;
        this.originalName = originalName;
    }
}
