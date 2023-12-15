package com.example.postservice.service.Post.Dto.Response;

import com.example.postservice.service.Post.Dto.Request.ParagraphRequestDto;
import com.example.postservice.service.Post.Entity.Category;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    // 포스트 제목
    private String title;
    // 포스트 카테고리
    private Category category;
    // 포스트의 각 문단들 리스트
    private List<ParagraphResponseDto> paragraph;
    // 포스트의 태그 리스트
    private List<String> tags;
    @Builder
    public PostResponseDto(String title, Category category, List<ParagraphResponseDto> paragraph, List<String> tags) {
        this.title = title;
        this.category = category;
        this.paragraph = paragraph;
        this.tags = tags;
    }
}
