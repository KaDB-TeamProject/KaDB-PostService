package com.example.postservice.Entity.schedule;

import jakarta.persistence.*;

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Paragraph paragraph;
    private String url;
}
