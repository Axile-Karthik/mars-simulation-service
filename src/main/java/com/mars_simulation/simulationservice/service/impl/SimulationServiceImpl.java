package com.mars_simulation.simulationservice.service.impl;

import com.mars_simulation.simulationservice.snapshot.SnapShotBuilder;
import com.mars_simulation.simulationservice.snapshot.dto.Player;
import com.mars_simulation.simulationservice.snapshot.dto.SnapShotDto;
import com.mars_simulation.simulationservice.service.SimulationService;
import com.mars_simulation.simulationservice.player.PlayerComponent;
import com.mars_simulation.simulationservice.tick.TickEngine;
import com.mars_simulation.simulationservice.world.WorldState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class SimulationServiceImpl implements SimulationService {

    private final SnapShotBuilder snapShotBuilder;
    private final WorldState worldState;


    @Override
    public SnapShotDto getWorldState(Map<Long, Player> playerCoordinates) {

        log.info("player coordinates :{}", playerCoordinates);

        playerCoordinates.forEach((playerId, playerDto) -> {

            PlayerComponent component = new PlayerComponent();

            component.setPlayerId(playerId);

            PlayerComponent.Position position = new PlayerComponent.Position();
            position.setX(playerDto.getPlayerPosition().getX());
            position.setY(playerDto.getPlayerPosition().getY());
            position.setZ(playerDto.getPlayerPosition().getZ());

            component.setPlayerPosition(position);

            worldState.getLatestPlayerMovement().put(playerId, component);
        });

        return snapShotBuilder.createWorldSnapShot();
    }

}
