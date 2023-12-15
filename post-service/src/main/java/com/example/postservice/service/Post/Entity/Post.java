package com.example.postservice.service.Post.Entity;

import com.example.postservice.service.Comment.Entity.Comment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @Column(columnDefinition = "int default 0")
    private Long views;
    @Column(columnDefinition = "int default 0")
    private Long likes;
    @CreationTimestamp
    private LocalDateTime postTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @ManyToOne
    @JoinColumn
    private Category category;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Schedule> schedules;

    @Builder
    public Post(String title, Category category) {
        this.title = title;
        this.category = category;
    }
}
