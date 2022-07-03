package com.spring.secirity.infrastructure.repository;

import com.spring.secirity.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
