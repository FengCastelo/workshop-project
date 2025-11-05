package com.fengcastelo.project.Services;

import com.fengcastelo.project.Model.Entities.User;
import com.fengcastelo.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
         Optional<User> obj = userRepository.findById(id);
         return obj.get();
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }
}
