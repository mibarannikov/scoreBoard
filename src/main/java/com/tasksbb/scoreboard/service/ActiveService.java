package com.tasksbb.scoreboard.service;

import com.tasksbb.scoreboard.dto.TrainDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
@Getter
@Setter
@Slf4j
public class ActiveService {

    private final RestTemplate restTemplate;

    private List<TrainDto> trains;

    @JmsListener(destination = "one")
    public void updateTrains(String message) {
      log.debug("message received {} from ActiveMQ destination one, time {} ", message , LocalDateTime.now());
        get();

    }

    @PostConstruct
    public void init() {
        get();
    }

    private void get(){
        trains = restTemplate.exchange("http://localhost:8080/api/station/stationschedule?station=all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<TrainDto>>() {
                }).getBody();
    }
}
