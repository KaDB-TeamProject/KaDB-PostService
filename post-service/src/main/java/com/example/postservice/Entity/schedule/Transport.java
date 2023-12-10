package com.example.postservice.Entity.schedule;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
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
}
