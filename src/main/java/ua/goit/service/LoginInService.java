package ua.goit.service;

import ua.goit.model.Users;

public interface LoginInService {
  Users getUser(String login);
  boolean checkPassword(Users users, String Password);
  String generateToken(Users users);
  void updateToken(Users users);
}