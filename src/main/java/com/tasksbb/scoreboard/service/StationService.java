package com.tasksbb.scoreboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StationService {
    private final RestTemplate restTemplate;

    public Object getStations(String nameStation) {
    return restTemplate
                .getForObject("http://localhost:8080/api/station/search?value="+nameStation,Object.class);
    }


}
