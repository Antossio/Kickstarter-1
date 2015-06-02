package ua.goit.service;

import ua.goit.model.Users;

public interface UserService extends GenericService<Users> {

  Users getByLogin(String login);
  Users findByToken(String token);
  Users findByActivationKey(String key);
}