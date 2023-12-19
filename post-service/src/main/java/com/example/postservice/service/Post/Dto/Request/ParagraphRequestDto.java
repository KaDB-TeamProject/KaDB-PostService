package com.example.postservice.service.Post.Dto.Request;

import com.example.postservice.service.Post.Entity.Paragraph;
import com.example.postservice.service.Post.Entity.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class ParagraphRequestDto {
    private Long id;
    // 장소 이름
    private String place;
    // 상세 주소
    private String address;
    // 작성한 글
    private String text;
    private List<MultipartFile> images;
    private List<TransportRequestDto> transports;
    @Builder
    public ParagraphRequestDto(String place, String address, String text, List<MultipartFile> images, List<TransportRequestDto> transports) {
        this.place = place;
        this.address = address;
        this.text = text;
        this.images = images;
        this.transports = transports;
    }
    public Paragraph toEntity(Schedule schedule){
        return Paragraph.builder().
                place(this.place).
                address(this.address).
                text(this.text).
                schedule(schedule).
                build();
    }
}
