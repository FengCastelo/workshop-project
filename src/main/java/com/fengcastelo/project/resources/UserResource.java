package com.fengcastelo.project.resources;

import com.fengcastelo.project.Model.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("maria@gmail.com", 1, "Maria", "123456", "9999999");
        return ResponseEntity.ok().body(u);
    }
}
