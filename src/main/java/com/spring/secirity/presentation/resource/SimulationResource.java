package com.spring.secirity.presentation.resource;


import com.spring.secirity.application.core.SimulationService;
import com.spring.secirity.infrastructure.model.Simulation;
import com.spring.secirity.infrastructure.util.IResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/simulations")
public class SimulationResource implements IResource<Simulation> {

    @Autowired
    private SimulationService simulationService;

    @Override
    public ResponseEntity<?> searchAll() {
        return ResponseEntity.ok(this.simulationService.searchAll());
    }

    @Override
    public ResponseEntity<?> searchById(Integer id) {
        return ResponseEntity.ok(this.simulationService.searchById(id));
    }

    @Override
    public ResponseEntity<?> save(Simulation simulation) {
        return ResponseEntity.ok(this.simulationService.save(simulation));
    }

    @Override
    public ResponseEntity<?> update(Simulation simulation) {
        return ResponseEntity.ok(this.simulationService.update(simulation));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        this.simulationService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
