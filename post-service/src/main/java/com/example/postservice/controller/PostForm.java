package com.example.postservice.controller;

import lombok.*;

import java.util.List;
import java.util.Optional;

@Getter @Setter
public class PostForm {
    // 포스트 제목
    private String title;
    // 포스트 카테고리
    private String category;
    // 포스트의 각 문단들 리스트
    private List<ParagraphForm> paragraph;
    // 포스트의 태그 리스트
    private List<String> tags;
}
