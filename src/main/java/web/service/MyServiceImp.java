package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DaoUser;
import web.model.User;

import java.beans.Transient;
import java.util.List;

@Service
public class MyServiceImp implements MyService {

    @Autowired
    DaoUser daoUser;

    @Override
    @Transactional
    public void addUser(User user) {
        daoUser.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        daoUser.updateUser(user);
    }

    @Override
    @Transactional
    public void removeById(int id) {
        daoUser.removeById(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return daoUser.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return daoUser.listUsers();
    }
}
