package com.example.postservice.service.Post.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String place;
    @Column
    private String address;
    @Column
    private String text;
    @ManyToOne
    @JoinColumn
    private Schedule schedule;
    @OneToMany
    private List<Transport> transport;
    @OneToMany
    private List<Images> images;

    @Builder
    public Paragraph(String place, String address, String text, Schedule schedule) {
        this.place = place;
        this.address = address;
        this.text = text;
        this.schedule = schedule;
    }
}
