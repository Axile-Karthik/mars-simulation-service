package com.mars_simulation.simulationservice.player;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class PlayerComponent {

    private Long playerId;
    private Position playerPosition;



    @Getter
    @Setter
    public static class Position {

        private Double x;
        private Double y;
        private Double z;

    }
    }
