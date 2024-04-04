package com.hans.backend.backend.appl.actors.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.hans.backend.backend.appl.actors.business.PlayerEntity;
import com.hans.backend.backend.appl.actors.business.repository.impl.PlayerRepository;
import com.hans.backend.backend.appl.actors.service.mapper.impl.PlayerMapper;
import com.hans.backend.backend.appl.actors.service.dto.Player;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;
    private final PlayerMapper playerMapper;

    public Player create(Player dto) {
        return playerMapper.toDTO(repository.save(playerMapper.toEntity(dto)));
    }

    public List<Player> getAll() {
        return playerMapper.toDTO(repository.findAll());
    }

    public Player getById(Long id) {
        Optional<PlayerEntity> found = repository.findById(id);
        if (found.isPresent()) {
            return playerMapper.toDTO(found.get());
        }
        return null;
    }

    public Player update(Player dto) {
        return playerMapper.toDTO(repository.save(playerMapper.toEntity(dto)));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}