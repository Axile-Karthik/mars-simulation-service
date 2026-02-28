package com.mars_simulation.simulationservice.controller;

import com.mars_simulation.simulationservice.snapshot.dto.Player;
import com.mars_simulation.simulationservice.snapshot.dto.SnapShotDto;
import com.mars_simulation.simulationservice.service.SimulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class TickController {

    private final SimulationService simulationService;


    @PostMapping("/world-state")
    public SnapShotDto getWorldState(@RequestBody Map<Long,Player> playerCoordinates){
        try {
            return simulationService.getWorldState(playerCoordinates);

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        }

    }


