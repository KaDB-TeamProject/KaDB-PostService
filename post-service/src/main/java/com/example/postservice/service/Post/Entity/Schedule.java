package com.example.postservice.service.Post.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Post post;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Paragraph> paragraphs;
    @Builder
    public Schedule(Post post){
        this.post = post;
    }
    public void addParagraph(Paragraph paragraph){
        if(paragraphs == null){
           paragraphs = new ArrayList<Paragraph>();
        }
        this.paragraphs.add(paragraph); }
}
