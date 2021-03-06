package com.informatorio.jblog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.informatorio.jblog.services.UserService;
import com.informatorio.jblog.models.User;
// import com.informatorio.jblog.repository.UserRepository;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    // @Autowired
    // private UserRepository UserRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value="id") Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    @ResponseStatus( HttpStatus.CREATED )
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/users/{id}/delete")
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deleteUserById(@PathVariable(value="id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/users/{id}/update")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
      User user = userService.updateUser(id, userDetails);
      return ResponseEntity.ok(user);
    }
}
