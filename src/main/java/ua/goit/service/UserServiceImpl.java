package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dao.UserDao;
import ua.goit.model.Users;

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
  public void add(Users entity) {
    userDao.add(entity);
  }

  @Override
  public Users getById(Integer id) {
    return userDao.getById(id);
  }

  @Override
  public List<Users> getAll() {
    return userDao.getAll();
  }

  @Override
  public void update(Users entity) {
    userDao.update(entity);
  }

  @Override
  public void remove(Integer id) {
    userDao.remove(id);
  }

  @Override
  public Users getByLogin(String login) {
    return userDao.getUserByLogin(login);
  }

  @Override
  public Users findByToken(String token) {
    return userDao.findUserByToken(token);
  }

  @Override
  public Users findByActivationKey(String key) {
    return userDao.findUserByActivationKey(key);
  }
}