package com.spring.secirity.infrastructure.repository;

import com.spring.secirity.infrastructure.model.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISimulationRepository extends JpaRepository<Simulation, Integer> {
}
