package com.mars_simulation.simulationservice.snapshot.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SnapShotDto {

    private Long tick;
    private LocalDateTime worldTime;
    private Environment environment;
    private Map<Long,Player> players;



}
