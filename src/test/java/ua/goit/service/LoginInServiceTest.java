package ua.goit.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import ua.goit.dao.UserDao;
import ua.goit.model.Users;

public class LoginInServiceTest {
  private final String login = "login";
  private final String password = "password";
  private final String wrongPassword = "wrongPassword";

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Mock
  private UserDao userDao;

  @InjectMocks
  UserServiceImpl userService;

  @Test
  public void userFromDBAndRightPassword_GetUserFromDBAndCheckHisPassword_LoginOk() {
    Users users = new Users(1, "user", login, password, null, null, null);
    when(userDao.getUserByLogin(anyString())).thenReturn(users);
    LoginInService loginInService = new LoginInServiceImpl(userService);
    Users userFromLoginService = loginInService.getUser(login);
    boolean isRightPass = loginInService.checkPassword(userFromLoginService, password);
    Assert.assertTrue(isRightPass);
    verify(userDao).getUserByLogin(anyString());
  }

  @Test
  public void userFromDBAndWrongPassword_GetUserFromDBAndCheckHisPassword_LoginNotOK() {
    Users users = new Users(1, "user", login, password, null, null, null);
    when(userDao.getUserByLogin(anyString())).thenReturn(users);
    LoginInService loginInService = new LoginInServiceImpl(userService);
    Users userFromLoginService = loginInService.getUser(login);
    boolean isRightPass = loginInService.checkPassword(userFromLoginService, wrongPassword);
    Assert.assertFalse(isRightPass);
  }
}