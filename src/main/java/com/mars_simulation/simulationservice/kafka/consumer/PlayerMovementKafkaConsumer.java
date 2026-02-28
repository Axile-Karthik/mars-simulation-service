package com.mars_simulation.simulationservice.kafka.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PlayerMovementKafkaConsumer {



    @KafkaListener(
            topics = "${spring.kafka.consumer.player-topic-name}",
            groupId = "mars-sim-group-v1"
    )
    public void consume(String message) {




    }
}

