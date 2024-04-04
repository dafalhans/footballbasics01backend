package com.hans.backend.backend.appl.teams.business.repository.impl;

import org.springframework.stereotype.Repository;
import com.hans.backend.backend.appl.teams.business.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

}