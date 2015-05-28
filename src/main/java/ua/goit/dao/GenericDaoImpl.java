package ua.goit.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.goit.model.Project;

import java.util.List;

import javax.transaction.Transactional;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
  private final Class<T> tClass;
  private static final Logger logger = Logger.getLogger(GenericDaoImpl.class);
  GenericDaoImpl(final Class<T> tClass) {
    this.tClass = tClass;
  }

  @Autowired
  SessionFactory sessionFactory;

  @Override
  public void add(T entity) {
    sessionFactory.getCurrentSession().save(entity);
  }

  @Override
  public T getById(Integer id) {
    return (T) sessionFactory.getCurrentSession().get(tClass, id);
  }

  @Override
  public List getAll() {
    String sql = "From " + tClass.getSimpleName();
    logger.info(sql);
    return sessionFactory.getCurrentSession().createQuery(sql).list();
  }

  @Override
  public void update(T entity) {
    sessionFactory.getCurrentSession().saveOrUpdate(entity);
  }

  @Override
  public void remove(Integer id) {
    T entity = getById(id);
    if (entity != null) {
      sessionFactory.getCurrentSession().delete(entity);
    }
  }
}
