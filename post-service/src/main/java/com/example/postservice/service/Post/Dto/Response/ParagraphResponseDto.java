package com.example.postservice.service.Post.Dto.Response;

import com.example.postservice.service.Post.Dto.Request.TransportRequestDto;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
public class ParagraphResponseDto {
    private Long id;
    // 장소 이름
    private String place;
    // 상세 주소
    private String address;
    // 작성한 글
    private String text;
    private List<ImagesResponseDto> images;
    private List<TransportResponseDto> transports;
    @Builder
    public ParagraphResponseDto(String place, String address, String text, List<ImagesResponseDto> images, List<TransportResponseDto> transports) {
        this.place = place;
        this.address = address;
        this.text = text;
        this.images = images;
        this.transports = transports;
    }
}
