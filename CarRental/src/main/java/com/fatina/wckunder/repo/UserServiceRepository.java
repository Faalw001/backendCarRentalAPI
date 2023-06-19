package com.fatina.wckunder.repo;

import com.fatina.wckunder.model.User;

import java.util.List;

public interface UserServiceRepository {
     User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
    User updateUser(User user, int id);
    Void deleteUser(int id);


}
