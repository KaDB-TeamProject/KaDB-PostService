package com.example.postservice.service.Post.Entity;

import com.example.postservice.service.Comment.Entity.Comment;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
public class Post {
    // 해당 프로퍼티가 테이블의 PK 역할을 한다는 것을 의미한다
    @Id
    // PK의 값을 위한 자동 생성 전략을 명시하는데 사용된다.
    // GenerationType의 종류
        // AUTO : 데이터베이스의 방언에 따라 자동으로 기본값 지정
        // IDENTITY : PK 생성을 데이터베이스에 위임
        // SEQUENCE : 데이터베이스 오브젝트 이용. 데이터베이스 시퀀스를 사용해 PK 할당.추가로 @SequenceGenerator 필요
        // TABLE : 별도의 키 생성 테이블 사용. 추가로 @TableGenerator 필요
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column
    @ColumnDefault("0")
    private Long views;
    @Column
    @ColumnDefault("0")
    private Long likes;
    @CreationTimestamp
    private LocalDateTime postTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @Builder
    public Post(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public void editPost(String title, Category category){
        this.title = title;
        this.category = category;
    }

   public void addComment(Comment comment){
        if (comments == null){
            comments = new ArrayList<Comment>();
        }
        comments.add(comment);
    }

    public void addSchedule(Schedule schedule){
        if (schedules == null){
            schedules = new ArrayList<Schedule>();
        }
        schedules.add(schedule);
    }
}
