package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public static final UserDaoJdbcImpl dao=new UserDaoJdbcImpl();


    public void createUsersTable() {
        dao.createUsersTable();

    }

    public void dropUsersTable() {
        dao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
dao.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();

    }


    public void cleanUsersTable() {
        dao.cleanUsersTable();

    }
}
