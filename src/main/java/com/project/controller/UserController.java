package com.project.controller;

import com.project.model.User;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fajaryudi
 * @created 2023/02/20 - 10.35
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findByid(@PathVariable("id") long id) throws Exception {
        User user = userRepository.findById(id);
        if (user != null){
            return user;
        }
        throw new Exception("User not found");
    }

    @PostMapping
    public User insert(@RequestBody User user) throws Exception {
        if (userRepository.insert(user)==1){
            return user;
        }
        throw new Exception("Error insert");
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable("id") long id) throws Exception {
        User userData = userRepository.findById(id);
        if (userData!=null){
            user.setId(id);
            if (userRepository.update(user)==1){
                return user;
            }
            throw new Exception("Error update");
        }
        throw new Exception("User not found");
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") long id) throws Exception {
        User user = userRepository.findById(id);
        if (user!=null){
            if (userRepository.deleteById(id)==1){
                return user;
            }
            throw new Exception("Error delete");
        }
        throw new Exception("User not found");
    }
}
