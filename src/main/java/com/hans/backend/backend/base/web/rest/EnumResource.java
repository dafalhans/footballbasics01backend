package com.hans.backend.backend.base.web.rest;

import com.hans.backend.backend.appl.actors.service.dto.Player;
import com.hans.backend.backend.appl.actors.service.service.PlayerService;
import com.hans.backend.backend.appl.actors.web.rest.PlayerResource;
import com.hans.backend.backend.appl.utils.BasePositionEnum;
import com.hans.backend.backend.appl.utils.TrainerSpecialty;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EnumResource {

    private final Logger logger = LoggerFactory.getLogger(EnumResource.class);


    @GetMapping("/enums/health")
    public ResponseEntity<String> up() {
        return ResponseEntity.ok("Enum Resource up and running");
    }

    @GetMapping("/enums/basepositions")
    public ResponseEntity<BasePositionEnum[]> getAllBasePositions() {
        logger.debug("Get all basepositions ");
        return ResponseEntity.ok(BasePositionEnum.values());
    }

    @GetMapping("/enums/trainerspecialties")
    public ResponseEntity<TrainerSpecialty[]> getAllTrainerSpecialties() {
        logger.debug("Get all trainerspecialties ");
        return ResponseEntity.ok(TrainerSpecialty.values());
    }

}
