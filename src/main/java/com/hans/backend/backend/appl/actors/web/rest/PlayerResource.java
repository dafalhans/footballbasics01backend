package com.hans.backend.backend.appl.actors.web.rest;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hans.backend.backend.appl.actors.service.service.PlayerService;
import com.hans.backend.backend.appl.actors.service.dto.Player;

import java.lang.reflect.Field;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PlayerResource {

    private final Logger logger = LoggerFactory.getLogger(PlayerResource.class);

    private final PlayerService service;

    @GetMapping("/players/health")
    public ResponseEntity<String> up() {
        return ResponseEntity.ok("Player Resource up and running");
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAll() {
        logger.debug("Get all players ");
        List<Player> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id) {
        logger.debug("Get Player by id: {}", id);
        Player dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/players")
//    public ResponseEntity<String> create(@RequestBody Player dto) {
//    public ResponseEntity<Object> create(@RequestBody Player dto) {
    public ResponseEntity<EntityModel<Player>> create(@RequestBody Player dto) {
        logger.debug("Create Player: {}", dto);
        Player newDto = new Player();

        Field[] fields = Player.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(dto);
                if (value != null && (value instanceof String && !((String) value).isEmpty())) {
                    field.set(newDto, value);
                } else if (value != null) {
                    field.set(newDto, value);
                }
            } catch (IllegalAccessException e) {
                logger.error("Error accessing field: {}", e.getMessage());
            }
        }

        String newDtoId = service.create(newDto).getId();

//        String playerId = newPlayer.getId();
        String url = WebMvcLinkBuilder.linkTo(methodOn(PlayerResource.class).getById(Long.valueOf(newDtoId))).toUri().toString();

        // Add HATEOAS link to the response
        EntityModel<Player> playerModel = EntityModel.of(newDto);
        playerModel.add(WebMvcLinkBuilder.linkTo(methodOn(PlayerResource.class).getById(Long.valueOf(newDtoId))).withSelfRel());

        return ResponseEntity.created(URI.create(url)).body(playerModel);

//        return ResponseEntity.ok("Player created");
    }

    @PutMapping("/players")
    public ResponseEntity<Player> update(@RequestBody Player dto) {
        logger.debug("Update Player: {}", dto);
//        logger.debug("Update Player: {}", dto.getBirthDate());
//        logger.debug("Update Player: {}", dto.getBirthDate().toString());
        Player updatedDto = service.update(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.debug("Delete Player by id: {}", id);
        service.deleteById(id);
        return ResponseEntity.ok("Player delete");
    }

}