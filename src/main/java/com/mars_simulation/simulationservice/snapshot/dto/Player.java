package com.mars_simulation.simulationservice.snapshot.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Player {

    private Long playerId;
    private Position playerPosition;



    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Position{

        private Double x;
        private Double y;
        private Double z;

    }

}

