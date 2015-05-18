package ua.goit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.goit.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

  UserDaoImpl() {
    super(User.class);
  }

  @Override
  public User getUserByLogin(String login) {
    String sql = "from User where login =:login";
    Query query = getQuery(sql);
    User user = (User) query.setParameter("login", login).uniqueResult();
    return user;
  }

  @Override
  public User findUserByToken(String token) {
    String sql = "from User where token =:token";
    Query query = getQuery(sql);
    User user = (User) query.setParameter("token", token).uniqueResult();
    return user;
  }

  @Override
  public User findUserByActivationKey(String key) {
    String sql = "from User where activationKey =:key";
    Query query = getQuery(sql);
    User user = (User) query.setParameter("key", key).uniqueResult();
    return user;
  }

  private Query getQuery(String sql) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.createQuery(sql);
  }
}