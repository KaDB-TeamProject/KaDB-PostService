package com.example.postservice.service.Post.Dto.Request;

import com.example.postservice.service.Post.Entity.Images;
import com.example.postservice.service.Post.Entity.Paragraph;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ImagesRequestDto {
    private Long id;
    private String url;
    @Builder
    public ImagesRequestDto(String url) {
        this.url = url;
    }
    public Images toEntity(Paragraph paragraph){
        return Images.builder().
                paragraph(paragraph).
                url(this.url).
                build();
    }
}
