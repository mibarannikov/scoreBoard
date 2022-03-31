package com.tasksbb.scoreboard.service;

import com.tasksbb.scoreboard.dto.TrainDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;


@RequiredArgsConstructor
@Service
@Getter
@Setter
public class ActiveService {
    private List<TrainDto> trains;

    @JmsListener(destination = "one")
    public void updateTrains() {

        trains = new RestTemplate().exchange("http://localhost:8080/api/station/stationschedule?station=all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<TrainDto>>() {
                }).getBody();
    }


    @PostConstruct
    public void init() {
        trains = new RestTemplate().exchange("http://localhost:8080/api/station/stationschedule?station=all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<TrainDto>>() {
                }).getBody();
    }
}
