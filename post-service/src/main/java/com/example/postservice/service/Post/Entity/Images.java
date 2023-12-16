package com.example.postservice.service.Post.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Builder
    public Images(Paragraph paragraph, String url) {
        this.paragraph = paragraph;
        this.url = url;
    }
}
