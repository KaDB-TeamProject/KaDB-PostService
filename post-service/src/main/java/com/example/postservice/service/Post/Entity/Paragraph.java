package com.example.postservice.service.Post.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.AbstractList;
import java.util.ArrayList;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Schedule schedule;
    @OneToMany(mappedBy = "paragraph",cascade = CascadeType.ALL)
    private List<Transport> transports;
    @OneToMany(mappedBy = "paragraph",cascade = CascadeType.ALL)
    private List<Images> images;

    @Builder
    public Paragraph(String place, String address, String text, Schedule schedule) {
        this.place = place;
        this.address = address;
        this.text = text;
        this.schedule = schedule;
    }
    public void addTransport(Transport transport){
        if (transports == null){
            transports = new ArrayList<Transport>();
        }
        transports.add(transport);
    }
    public void addImages(Images image){
        if (images == null){
            images = new ArrayList<Images>();
        }
        images.add(image);
    }
}
