package com.spring.secirity.infrastructure.repository;

import com.spring.secirity.infrastructure.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
