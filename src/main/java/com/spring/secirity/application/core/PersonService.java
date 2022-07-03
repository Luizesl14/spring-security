package com.spring.secirity.application.core;

import com.spring.secirity.infrastructure.model.Person;
import com.spring.secirity.infrastructure.repository.IPersonRepository;
import com.spring.secirity.infrastructure.util.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonService implements IService<Person> {

    @Autowired
    private IPersonRepository ipersonRepository;


    @Override
    public List<Person> searchAll() {
        return this.ipersonRepository.findAll();
    }

    @Override
    public Person searchById(Integer id) {
        return this.ipersonRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Objeto nao encontrado!"));
    }

    @Override
    public Person save(Person person) {
        return this.ipersonRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        Person personDatabase = this.searchById(person.getId());
        BeanUtils.copyProperties(person, personDatabase, "id","craatedAt");
        return this.ipersonRepository.save(personDatabase);
    }

    @Override
    public void delete(Integer id) {
     this.ipersonRepository.deleteById(id);
    }
}
