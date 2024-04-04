package com.hans.backend.backend.appl.actors.business.repository.impl;

import org.springframework.stereotype.Repository;
import com.hans.backend.backend.appl.actors.business.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {

}