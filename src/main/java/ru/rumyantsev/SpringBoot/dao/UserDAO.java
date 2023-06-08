package ru.rumyantsev.SpringBoot.dao;


import ru.rumyantsev.SpringBoot.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void removeUserById(Long id);

    void updateUser(User updateUser);

}
