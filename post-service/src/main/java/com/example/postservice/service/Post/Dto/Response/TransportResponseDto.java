package com.example.postservice.service.Post.Dto.Response;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TransportResponseDto {
    private Long id;
    // 교통수단
    private String transport;
    // 교통수단 이름
    private String transportName;
    // 이동하는데 걸린 시간
    private int time;
    // 이동하는데 걸린 비용
    private int money;
    @Builder
    public TransportResponseDto(String transport, String transportName, int time, int money) {
        this.transport = transport;
        this.transportName = transportName;
        this.time = time;
        this.money = money;
    }
}
