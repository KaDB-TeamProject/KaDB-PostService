package com.example.postservice.service.Post.Dto.Request;

import com.example.postservice.service.Post.Entity.Category;
import com.example.postservice.service.Post.Entity.Post;
import com.example.postservice.service.Post.Repository.CategoryRepository;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PostRequestDto {
    private Long id;
    // 포스트 제목
    private String title;
    // 포스트 카테고리
    private String category;
    // 포스트의 각 문단들 리스트
    private List<ScheduleRequestDto> schedules;
    // 포스트의 태그 리스트
    private List<String> tags;
    @Builder
    public PostRequestDto(String title, String category, List<ScheduleRequestDto> schedules, List<String> tags) {
        this.title = title;
        this.category = category;
        this.schedules = schedules;
        this.tags = tags;
    }
    public Post toEntity(Category category){
        return Post.builder().
                title(this.title).
                category(category).
                build();
    }
}
