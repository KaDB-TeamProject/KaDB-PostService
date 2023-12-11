package com.example.postservice.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
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
    private String title;

    private int views;
    private int likes;
    @CreationTimestamp
    private LocalDateTime postTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @ManyToOne
    @JoinColumn
    private Category category;

    public Post(String title, int views, int likes, Category category) {
        this.title = title;
        this.views = views;
        this.likes = likes;
        this.category = category;
    }
}
