package com.spring.secirity.presentation.resource;


import com.spring.secirity.application.core.PersonService;
import com.spring.secirity.infrastructure.model.Person;
import com.spring.secirity.infrastructure.util.IResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource implements IResource<Person> {

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<?> searchAll() {

        return ResponseEntity.ok(this.personService.searchAll());
    }

    @Override
    public ResponseEntity<?> searchById(Integer id) {
        return ResponseEntity.ok(this.personService.searchById(id));
    }

    @Override
    public ResponseEntity<?> save(Person person) {
        return ResponseEntity.ok(this.personService.save(person));
    }

    @Override
    public ResponseEntity<?> update(Person person) {
        return ResponseEntity.ok(this.personService.update(person));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        this.personService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
