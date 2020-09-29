package web.dao;

import web.model.User;

import java.util.List;

public interface DaoUser {
    void addUser(User user);
    void updateUser(User user);
    void removeById(int id);
    User getUserById(int id);
    List<User> listUsers();
}
