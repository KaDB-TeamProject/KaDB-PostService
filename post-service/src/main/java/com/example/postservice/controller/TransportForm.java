package com.example.postservice.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransportForm {
        // 교통수단
        private String transport;
        // 교통수단 이름
        private String transportName;
        // 이동하는데 걸린 시간
        private int time;
        // 이동하는데 걸린 비용
        private int money;
}
