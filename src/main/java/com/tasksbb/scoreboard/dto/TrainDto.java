package com.tasksbb.scoreboard.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TrainDto {
    public Long id;
    @NotEmpty
    private Long trainNumber;
    @NotEmpty
    private LocalDateTime departureTime;
    @NotEmpty
    private LocalDateTime arrivalTimeEnd;
    @NotEmpty
    private Double trainSpeed;
    @NotEmpty
    private Long sumSeats;
    private Long amountOfEmptySeats;
    @NotEmpty
    private List<PointOfScheduleDto> pointsOfSchedule = new ArrayList<>();
    @NotEmpty
    private  List<WagonDto> wagons = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDto trainDto = (TrainDto) o;
        return id.equals(trainDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainNumber, departureTime, arrivalTimeEnd, trainSpeed);
    }
}
