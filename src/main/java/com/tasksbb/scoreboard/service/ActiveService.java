package com.tasksbb.scoreboard.service;

import com.tasksbb.scoreboard.dto.TrainDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
@Getter
@Setter
@Slf4j
public class ActiveService {

    @Value("${train.ms.url}")
    private String trainMsUrl;
    private final RestTemplate restTemplate;

    private List<TrainDto> trains;

    @JmsListener(destination = "one")
    public void updateTrains(String message) {
        log.debug("message received {} from ActiveMQ destination one, time {} ", message, LocalDateTime.now());
        get();

    }

    //@PostConstruct
    @Scheduled(initialDelay = 1000 * 30, fixedDelay = Long.MAX_VALUE)
    public void init() {
        get();
    }

    private void get() {
        trains = restTemplate.exchange(trainMsUrl + "/api/station/stationschedule?station=all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<TrainDto>>() {
                }).getBody();
    }
}
