package com.mars_simulation.simulationservice.snapshot;

import com.mars_simulation.simulationservice.player.PlayerComponent;
import com.mars_simulation.simulationservice.snapshot.dto.Environment;
import com.mars_simulation.simulationservice.snapshot.dto.Player;
import com.mars_simulation.simulationservice.snapshot.dto.SnapShotDto;
import com.mars_simulation.simulationservice.world.WorldState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SnapShotBuilder {

    private final WorldState worldState;


    public SnapShotDto createWorldSnapShot(){

        SnapShotDto worldSnapShot = getSnapShotDto();
        Map<Long, PlayerComponent> playerCoordinates = worldState.getPlayer();
        playerCoordinates.forEach((playerId, playerDto) -> {

            Player player = new Player();

            player.setPlayerId(playerId);

            Player.Position position = new Player.Position();
            position.setX(playerDto.getPlayerPosition().getX());
            position.setY(playerDto.getPlayerPosition().getY());
            position.setZ(playerDto.getPlayerPosition().getZ());

            player.setPlayerPosition(position);
            worldSnapShot.getPlayers().put(playerId,player);

        });

        return worldSnapShot;
    }

    private SnapShotDto getSnapShotDto() {
        SnapShotDto worldSnapShot = new SnapShotDto();

        worldSnapShot.setTick(worldState.getTick());
        worldSnapShot.setWorldTime(worldState.getWorldTime());

        Environment environment = new Environment();
        environment.setDustLevel(worldState.getEnvironment().getDustLevel());
        environment.setTemperature(worldState.getEnvironment().getTemperature());
        environment.setWindSpeed(worldState.getEnvironment().getWindSpeed());

        worldSnapShot.setEnvironment(environment);

        worldSnapShot.setPlayers(new HashMap<>());

        return worldSnapShot;
    }
}
