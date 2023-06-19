package com.fatina.wckunder.service;


import com.fatina.wckunder.model.User;
import com.fatina.wckunder.repo.UserRepository;
import com.fatina.wckunder.repo.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceRepository {
    @Autowired
    private UserRepository userRepository;

    @Override
    public  User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = (userRepository.findById(id));
        if(user.isPresent()){
            return user.get();
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public User updateUser(User user, int id) {
        return null;
    }

    @Override
    public Void deleteUser(int id) {
        return null;
    }
}
