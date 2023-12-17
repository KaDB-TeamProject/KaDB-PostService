package com.example.postservice.service.Post.Dto.Request;

import com.example.postservice.service.Post.Entity.Post;
import com.example.postservice.service.Post.Entity.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDto {
    private Long id;
    private List<ParagraphRequestDto> paragraph;
    private String city;
    @Builder
    public ScheduleRequestDto(List<ParagraphRequestDto> paragraph, String city) {
        this.paragraph = paragraph;
        this.city = city;
    }
    public Schedule toEntity(Post post){
        return Schedule.builder().
                post(post).
                city(this.city).
                build();
    }
}
