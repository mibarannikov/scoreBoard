package com.tasksbb.scoreboard.web;

import com.tasksbb.scoreboard.dto.Response;
import com.tasksbb.scoreboard.service.ActiveService;
import com.tasksbb.scoreboard.service.StationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
@PreAuthorize("permitAll()")
@RequiredArgsConstructor
public class ActiveController {
    public static final Logger LOG = LoggerFactory.getLogger(ActiveController.class);
    private final JmsTemplate jmsTemplate;
    private final ActiveService activeService;
    private final StationService stationService;



    @GetMapping("/stations")
      public ResponseEntity<Object> getStations(@RequestParam(name = "value") String nameStation){
        return new ResponseEntity<>(stationService.getStations(nameStation),HttpStatus.OK);

    }

    @GetMapping("/update")
    public ResponseEntity<Object> update() {
        Object obj = activeService.getResp();
        System.out.println(obj);
        // if (obj==null) {obj="null";}
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }
}
