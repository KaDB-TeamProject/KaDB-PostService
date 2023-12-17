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
    private String originalName;
    @Builder
    public ImagesRequestDto(String url,String originalName) {
        this.url = url;
        this.originalName = originalName;
    }
    public Images toEntity(Paragraph paragraph){
        return Images.builder().
                paragraph(paragraph).
                url(this.url).
                originalName(this.originalName).
                build();
    }
}
