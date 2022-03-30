package com.tasksbb.scoreboard.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tasksbb.scoreboard.dto.TrainDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Getter
@Setter
public class ActiveService {
    private List<TrainDto> resp;
    private final ObjectMapper objectMapper;
    @JmsListener(destination = "one")
    public void updateMessage(){

      resp = new RestTemplate().exchange("http://localhost:8080/api/station/stationschedule?station=all",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<TrainDto>>() {
                        }).getBody();
        System.out.println(resp);
        System.out.println(resp.get(0).getTrainNumber());
    }

    @PostConstruct
    public void init(){
        List<TrainDto> resp =
                new RestTemplate().exchange("http://localhost:8080/api/station/stationschedule?station=all",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<TrainDto>>() {
                        }).getBody();
    }
}
