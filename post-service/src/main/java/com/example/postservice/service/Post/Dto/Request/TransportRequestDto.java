package com.example.postservice.service.Post.Dto.Request;

import com.example.postservice.service.Post.Entity.Paragraph;
import com.example.postservice.service.Post.Entity.Transport;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TransportRequestDto {
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
        public TransportRequestDto(String transport, String transportName, int time, int money) {
                this.transport = transport;
                this.transportName = transportName;
                this.time = time;
                this.money = money;
        }
        public Transport toEntity(Paragraph paragraph){
                return Transport.builder().
                        transport(this.transport).
                        transportName(this.transportName).
                        time(this.time).
                        money(this.money).
                        paragraph(paragraph).
                        build();
        }
}
