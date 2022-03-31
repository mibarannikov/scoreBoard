package com.tasksbb.scoreboard.service;

import com.tasksbb.scoreboard.dto.TrainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainService {
    public final ActiveService activeService;

    public List<TrainDto> getTrainsForSchedule(String nameStation){
        Set<TrainDto> trainForSchedule = activeService.getTrains().stream()
                .filter(tr-> tr.getPointsOfSchedule().stream()
                        .anyMatch(p->p.getNameStation().equals(nameStation)&&p.getDepartureTime().isAfter(LocalDateTime.now())))
                .distinct()
                .collect(Collectors.toSet());

        return new ArrayList(trainForSchedule);
    }
}
