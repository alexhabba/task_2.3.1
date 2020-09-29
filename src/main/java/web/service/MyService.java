package web.service;

import web.model.User;

import java.util.List;

public interface MyService {
    void addUser(User user);
    void updateUser(User user);
    void removeById(int id);
    User getUserById(int id);
    List<User> listUsers();
}
