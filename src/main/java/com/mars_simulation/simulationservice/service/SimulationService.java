package com.mars_simulation.simulationservice.service;

import com.mars_simulation.simulationservice.snapshot.dto.Player;
import com.mars_simulation.simulationservice.snapshot.dto.SnapShotDto;

import java.util.Map;

public interface SimulationService  {
    SnapShotDto getWorldState(Map<Long,Player> playerCoordinates);
}
