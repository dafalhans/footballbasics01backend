package com.hans.backend.backend.appl.actors.web.rest;

import com.hans.backend.backend.appl.actors.service.dto.Player;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hans.backend.backend.appl.actors.service.service.TrainerService;
import com.hans.backend.backend.appl.actors.service.dto.Trainer;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TrainerResource {

    private final Logger logger = LoggerFactory.getLogger(TrainerResource.class);

    private final TrainerService service;

    @GetMapping("/trainers/health")
    public ResponseEntity<String> up() {
        return ResponseEntity.ok("Trainer Resource up and running");
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getAll() {
        logger.debug("Get all trainers ");
        List<Trainer> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/trainers/{id}")
    public ResponseEntity<Trainer> getById(@PathVariable Long id) {
        logger.debug("Get Trainer by id: {}", id);
        Trainer dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/trainers")
//    public ResponseEntity<String> create(@RequestBody Trainer dto) {
    public ResponseEntity<EntityModel<Trainer>> create(@RequestBody Trainer dto) {
        logger.debug("Create Trainer: {}", dto);

        Trainer newDto = new Trainer();

        Field[] fields = Trainer.class.getDeclaredFields();
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
        String url = WebMvcLinkBuilder.linkTo(methodOn(TrainerResource.class).getById(Long.valueOf(newDtoId))).toUri().toString();

        // Add HATEOAS link to the response
        EntityModel<Trainer> trainerModel = EntityModel.of(newDto);
        trainerModel.add(WebMvcLinkBuilder.linkTo(methodOn(TrainerResource.class).getById(Long.valueOf(newDtoId))).withSelfRel());

        return ResponseEntity.created(URI.create(url)).body(trainerModel);


//        service.create(dto);
//        return ResponseEntity.ok("Trainer created");
    }

    @PutMapping("/trainers")
    public ResponseEntity<Trainer> update(@RequestBody Trainer dto) {
        logger.debug("Update Trainer: {}", dto);
        Trainer updatedDto = service.update(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/trainers/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.debug("Delete Trainer by id: {}", id);
        service.deleteById(id);
        return ResponseEntity.ok("Trainer delete");
    }

}