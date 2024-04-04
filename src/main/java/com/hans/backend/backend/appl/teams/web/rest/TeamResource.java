package com.hans.backend.backend.appl.teams.web.rest;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hans.backend.backend.appl.teams.service.service.TeamService;
import com.hans.backend.backend.appl.teams.service.dto.Team;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TeamResource {

    private final Logger logger = LoggerFactory.getLogger(TeamResource.class);

    private final TeamService service;

    @GetMapping("/teams/health")
    public ResponseEntity<String> up() {
        return ResponseEntity.ok("Team Resource up and running");
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAll() {
        logger.debug("Get all teams ");
        List<Team> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getById(@PathVariable Long id) {
        logger.debug("Get Team by id: {}", id);
        Team dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/teams")
    public ResponseEntity<String> create(@RequestBody Team dto) {
        logger.debug("Create Team: {}", dto);
        service.create(dto);
        return ResponseEntity.ok("Team created");
    }

    @PutMapping("/teams")
    public ResponseEntity<Team> update(@RequestBody Team dto) {
        logger.debug("Update Team: {}", dto);
        Team updatedDto = service.update(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.debug("Delete Team by id: {}", id);
        service.deleteById(id);
        return ResponseEntity.ok("Team delete");
    }

}