package com.mars_simulation.simulationservice.world;

import com.mars_simulation.simulationservice.environment.EnvironmentComponent;
import com.mars_simulation.simulationservice.player.PlayerComponent;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Getter
@Setter
public class WorldState {

    private long tick;

    private LocalDateTime worldTime;

    private EnvironmentComponent environment =  new EnvironmentComponent();

    private Map<Long, PlayerComponent> player = new ConcurrentHashMap<>();

    private Map<Long, PlayerComponent> latestPlayerMovement = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        environment.setTemperature(15.0);
        environment.setDustLevel(45.0);
        environment.setWindSpeed(5.0);
    }
}
