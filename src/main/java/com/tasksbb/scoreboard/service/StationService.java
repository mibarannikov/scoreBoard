package com.tasksbb.scoreboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StationService {
    private final RestTemplate restTemplate;

    @Value("${train.ms.url}")
    private String trainMsUrl;

    public Object getStations(String nameStation) {
    return restTemplate
                .getForObject(trainMsUrl+"/api/station/search?value="+nameStation,Object.class);
    }


}
