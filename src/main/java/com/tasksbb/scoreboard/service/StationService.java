package com.tasksbb.scoreboard.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StationService {

    public Object getStations(String nameStation) {
    return  new RestTemplate()
                .getForObject("http://localhost:8080/api/station/search?value="+nameStation,Object.class);
    }


}
