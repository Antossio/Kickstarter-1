package ua.goit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.goit.model.Users;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Users> implements UserDao {

  UserDaoImpl() {
    super(Users.class);
  }

  @Override
  public Users getUserByLogin(String login) {
    String sql = "from Users where login =:login";
    Query query = getQuery(sql);
    Users users = (Users) query.setParameter("login", login).uniqueResult();
    return users;
  }

  @Override
  public Users findUserByToken(String token) {
    String sql = "from Users where token =:token";
    Query query = getQuery(sql);
    Users users = (Users) query.setParameter("token", token).uniqueResult();
    return users;
  }

  @Override
  public Users findUserByActivationKey(String key) {
    String sql = "from Users where activationKey =:key";
    Query query = getQuery(sql);
    Users users = (Users) query.setParameter("key", key).uniqueResult();
    return users;
  }

  private Query getQuery(String sql) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.createQuery(sql);
  }
}