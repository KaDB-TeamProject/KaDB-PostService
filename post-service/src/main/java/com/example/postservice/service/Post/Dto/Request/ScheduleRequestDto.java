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
    @Builder
    public ScheduleRequestDto(List<ParagraphRequestDto> paragraph) {
        this.paragraph = paragraph;
    }
    public Schedule toEntity(Post post){
        return Schedule.builder().
                post(post).
                build();
    }
}
