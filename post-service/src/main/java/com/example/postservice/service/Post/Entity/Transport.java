package com.example.postservice.service.Post.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String transport;
    @Column
    private String transportName;
    @Column
    private int time;
    @Column
    private int money;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Paragraph paragraph;

    @Builder
    public Transport(String transport, String transportName, int time, int money, Paragraph paragraph) {
        this.transport = transport;
        this.transportName = transportName;
        this.time = time;
        this.money = money;
        this.paragraph = paragraph;
    }
}
