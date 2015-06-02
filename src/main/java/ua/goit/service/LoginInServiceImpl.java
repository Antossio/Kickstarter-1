package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.model.Users;

import javax.transaction.Transactional;

@Transactional
@Service
public class LoginInServiceImpl implements LoginInService {
  private final UserService userService;
  private Users users;

  @Autowired
  public LoginInServiceImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Users getUser(String login) {
    users = userService.getByLogin(login);
    return users;
  }

  @Override
  public boolean checkPassword(Users users, String password) {
    if (users != null) {
      String pass = users.getPassword();
      return pass.equals(password);
    } else {
    	return false;
    }
  }

  @Override
  public String generateToken(Users users) {
    String token;
    token = 31 * users.getId() + users.getLogin().hashCode() + "";
    users.setToken(token);
    return token;
  }

  @Override
  public void updateToken(Users users) {
    if (users != null) {
      userService.update(users);
    } else {
      throw new RuntimeException("User not found!!!");
    }
  }
}