package com.hans.backend.backend.appl.teams.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.hans.backend.backend.appl.teams.business.TeamEntity;
import com.hans.backend.backend.appl.teams.business.repository.impl.TeamRepository;
import com.hans.backend.backend.appl.teams.service.mapper.impl.TeamMapper;
import com.hans.backend.backend.appl.teams.service.dto.Team;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository repository;
    private final TeamMapper teamMapper;

    public Team create(Team dto) {
        return teamMapper.toDTO(repository.save(teamMapper.toEntity(dto)));
    }

    public List<Team> getAll() {
        return teamMapper.toDTO(repository.findAll());
    }

    public Team getById(Long id) {
        Optional<TeamEntity> found = repository.findById(id);
        if (found.isPresent()) {
            return teamMapper.toDTO(found.get());
        }
        return null;
    }

    public Team update(Team dto) {
        return teamMapper.toDTO(repository.save(teamMapper.toEntity(dto)));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}