package ua.goit.dao;

import ua.goit.model.Users;

public interface UserDao extends GenericDao<Users> {
    Users getUserByLogin(String login);
    Users findUserByToken(String token);
    Users findUserByActivationKey(String key);
}