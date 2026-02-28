package com.mars_simulation.simulationservice.snapshot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Environment {

    private Double temperature;
    private Double windSpeed;
    private Double dustLevel;
}
