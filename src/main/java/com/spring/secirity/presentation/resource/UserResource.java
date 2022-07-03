package com.spring.secirity.presentation.resource;


import com.spring.secirity.application.core.UserService;
import com.spring.secirity.infrastructure.model.User;
import com.spring.secirity.infrastructure.util.IResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements IResource<User> {

    @Autowired
    private UserService userService;

    @GetMapping
    @Override
    public ResponseEntity<?> searchAll() {
        return ResponseEntity.ok(this.userService.searchAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.save(user));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        this.userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
