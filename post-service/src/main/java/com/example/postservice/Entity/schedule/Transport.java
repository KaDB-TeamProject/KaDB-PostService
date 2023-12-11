package com.example.postservice.Entity.schedule;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transport;
    private String transportName;
    private int time;
    private int money;
    @ManyToOne
    @JoinColumn
    private Paragraph paragraph;

    public Transport(String transport, String transportName, int time, int money, Paragraph paragraph) {
        this.transport = transport;
        this.transportName = transportName;
        this.time = time;
        this.money = money;
        this.paragraph = paragraph;
    }
}
