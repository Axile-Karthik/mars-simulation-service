package com.mars_simulation.simulationservice.tick;

import com.mars_simulation.simulationservice.environment.EnvironmentComponent;
import com.mars_simulation.simulationservice.player.PlayerComponent;
import com.mars_simulation.simulationservice.world.WorldState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class TickEngine {

    private final WorldState worldState;

    @Scheduled(fixedRate = 1000)
    private void runTick(){

        worldState.setTick(worldState.getTick()+1);
        worldState.setWorldTime(LocalDateTime.now());

        EnvironmentComponent environment = worldState.getEnvironment();
        if (environment != null) {
            environment.setTemperature(environment.getTemperature() + 0.1);
            environment.setDustLevel(environment.getDustLevel() + 0.05);
        }

        Map<Long, PlayerComponent> inputs = worldState.getLatestPlayerMovement();

        if (inputs != null && !inputs.isEmpty()) {
            worldState.getPlayer().putAll(inputs);
            inputs.clear();
        }

        log.info("tick: {} time: {}", worldState.getTick(), worldState.getWorldTime());
    }

}
