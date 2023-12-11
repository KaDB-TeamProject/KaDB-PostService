package com.example.postservice.Entity.schedule;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Paragraph paragraph;
    private String url;

    public Images(Paragraph paragraph, String url) {
        this.paragraph = paragraph;
        this.url = url;
    }
}
