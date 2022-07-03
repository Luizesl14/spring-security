package com.spring.secirity.application.core;

import com.spring.secirity.infrastructure.model.User;
import com.spring.secirity.infrastructure.repository.IUserRepository;
import com.spring.secirity.infrastructure.util.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.beans.Encoder;
import java.util.List;

@Service
public class UserService implements IService<User> {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private  PasswordEncoder pass;


    @Override
    public List<User> searchAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public User searchById(Integer id) {
        return this.iUserRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Objeto nao encontrado!"));
    }

    @Override
    public User save(User user) {
        user.setPassword(this.pass.encode(user.getPassword()));
        return this.iUserRepository.save(user);
    }

    @Override
    public User update(User user) {
        User userDatabase = this.searchById(user.getId());
        BeanUtils.copyProperties(user, userDatabase, "id", "createdAt");
        return this.iUserRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
     this.iUserRepository.deleteById(id);
    }
}
