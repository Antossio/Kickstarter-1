package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.model.User;

import javax.transaction.Transactional;

@Transactional
@Service
public class LoginInServiceImpl implements LoginInService {
  private final UserService userService;
  private User user;

  @Autowired
  public LoginInServiceImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public User getUser(String login) {
    user = userService.getByLogin(login);
    return user;
  }

  @Override
  public boolean checkPassword(User user, String password) {
    if (user != null) {
      String pass = user.getPassword();
      return pass.equals(password);
    } else {
    	return false;
    }
  }

  @Override
  public String generateToken(User user) {
    String token;
    token = 31 * user.getId() + user.getLogin().hashCode() + "";
    user.setToken(token);
    return token;
  }

  @Override
  public void updateToken(User user) {
    if (user != null) {
      userService.update(user);
    } else {
      throw new RuntimeException("User not found!!!");
    }
  }
}