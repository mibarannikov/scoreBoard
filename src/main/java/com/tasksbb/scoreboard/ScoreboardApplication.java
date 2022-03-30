package com.tasksbb.scoreboard;

import com.google.gson.Gson;
import com.tasksbb.scoreboard.dto.PointOfScheduleDto;
import com.tasksbb.scoreboard.dto.TrainDto;
import com.tasksbb.scoreboard.service.ActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication

public class ScoreboardApplication {
//	@Autowired
//	private  ActiveService activeService ;
	public static void main(String[] args) {
		SpringApplication.run(ScoreboardApplication.class, args);


//		activeService.setResp(new RestTemplate()
//				.getForObject("http://localhost:8080/api/station/stationschedule?station=Москва", ArrayList.class));
//		Gson gson = new Gson();
//		System.out.println(activeService.getResp());

	}

}
