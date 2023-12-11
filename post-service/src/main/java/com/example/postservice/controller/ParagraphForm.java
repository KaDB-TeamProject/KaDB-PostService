package com.example.postservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Setter @Getter
public class ParagraphForm {
    // 장소 이름
    private String place;
    // 상세 주소
    private String address;
    // 작성한 글
    private String text;
    private List<MultipartFile> images;
    private List<TransportForm> transports;
}
