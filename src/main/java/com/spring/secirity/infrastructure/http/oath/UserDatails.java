package com.spring.secirity.infrastructure.http.oath;

import com.spring.secirity.infrastructure.model.User;
import com.spring.secirity.infrastructure.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDatails implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUserName(username);
        if(user.isPresent()){
            return new ResourceOwner(user.get());
        }else{
            throw new UsernameNotFoundException("Usuario nao encontado!");
        }
    }
}
