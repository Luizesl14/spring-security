package com.spring.secirity.application.core;

import com.spring.secirity.infrastructure.model.Simulation;
import com.spring.secirity.infrastructure.repository.ISimulationRepository;
import com.spring.secirity.infrastructure.util.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SimulationService implements IService<Simulation> {

    @Autowired
    private ISimulationRepository iSimulationRepository;

    @Override
    public List<Simulation> searchAll() {
        return this.iSimulationRepository.findAll();
    }

    @Override
    public Simulation searchById(Integer id) {
        return this.iSimulationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Objeto nao encontrado!"));
    }

    @Override
    public Simulation save(Simulation simulation) {
        return this.iSimulationRepository.save(simulation);
    }

    @Override
    public Simulation update(Simulation simulation) {
        Simulation simulationDatabase = this.searchById(simulation.getId());
        BeanUtils.copyProperties(simulation, simulationDatabase, "id", "cratedAt");
        return this.iSimulationRepository.save(simulationDatabase);
    }

    @Override
    public void delete(Integer id) {
      this.iSimulationRepository.deleteById(id);
    }
}
