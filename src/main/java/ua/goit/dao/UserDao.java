package ua.goit.dao;

import ua.goit.model.User;

public interface UserDao extends GenericDao<User> {
    User getUserByLogin(String login);
    User findUserByToken(String token);
    User findUserByActivationKey(String key);
}