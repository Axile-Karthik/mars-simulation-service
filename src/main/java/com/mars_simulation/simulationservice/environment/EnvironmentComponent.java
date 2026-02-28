package com.mars_simulation.simulationservice.environment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class EnvironmentComponent {

    private Double temperature;
    private Double windSpeed;
    private Double dustLevel;
}
