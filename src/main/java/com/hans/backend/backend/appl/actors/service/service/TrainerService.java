package com.hans.backend.backend.appl.actors.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.hans.backend.backend.appl.actors.business.TrainerEntity;
import com.hans.backend.backend.appl.actors.business.repository.impl.TrainerRepository;
import com.hans.backend.backend.appl.actors.service.mapper.impl.TrainerMapper;
import com.hans.backend.backend.appl.actors.service.dto.Trainer;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainerService {

    private final TrainerRepository repository;
    private final TrainerMapper trainerMapper;

    public Trainer create(Trainer dto) {
        return trainerMapper.toDTO(repository.save(trainerMapper.toEntity(dto)));
    }

    public List<Trainer> getAll() {
        return trainerMapper.toDTO(repository.findAll());
    }

    public Trainer getById(Long id) {
        Optional<TrainerEntity> found = repository.findById(id);
        if (found.isPresent()) {
            return trainerMapper.toDTO(found.get());
        }
        return null;
    }

    public Trainer update(Trainer dto) {
        return trainerMapper.toDTO(repository.save(trainerMapper.toEntity(dto)));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}