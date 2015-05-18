package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dao.UserDao;
import ua.goit.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;
  
  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void add(User entity) {
    userDao.add(entity);
  }

  @Override
  public User getById(Integer id) {
    return userDao.getById(id);
  }

  @Override
  public List<User> getAll() {
    return userDao.getAll();
  }

  @Override
  public void update(User entity) {
    userDao.update(entity);
  }

  @Override
  public void remove(User entity) {
    userDao.remove(entity);
  }

  @Override
  public User getByLogin(String login) {
    return userDao.getUserByLogin(login);
  }

  @Override
  public User findByToken(String token) {
    return userDao.findUserByToken(token);
  }

  @Override
  public User findByActivationKey(String key) {
    return userDao.findUserByActivationKey(key);
  }
}