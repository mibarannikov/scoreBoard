package com.tasksbb.scoreboard.web;

import com.tasksbb.scoreboard.dto.Response;
import com.tasksbb.scoreboard.service.ActiveService;
import com.tasksbb.scoreboard.service.StationService;
import com.tasksbb.scoreboard.service.TrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
@PreAuthorize("permitAll()")
@RequiredArgsConstructor
@Slf4j
public class ActiveController {

    private final StationService stationService;
    private final TrainService trainService;

    @GetMapping("/stations")
      public ResponseEntity<Object> getStations(@RequestParam(name = "value") String nameStation){
        return new ResponseEntity<>(stationService.getStations(nameStation),HttpStatus.OK);

    }

    @GetMapping("/update")
    public ResponseEntity<Object> update(@RequestParam(name="nameStation") String nameStation) {
        Object obj = trainService.getTrainsForSchedule(nameStation);
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }
}
