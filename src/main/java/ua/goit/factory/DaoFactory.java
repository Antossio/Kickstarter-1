package ua.goit.factory;

import ua.goit.dao.*;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

  private final static DaoFactory instance = new DaoFactory();
  private Map<Class<?>, Class<?>> typeMap;

  private DaoFactory() {
    typeMap = new HashMap<>();
    typeMap.put(UserDao.class, UserDaoImpl.class);
    typeMap.put(CategoryDao.class, CategoryDaoImpl.class);
    typeMap.put(ProjectDao.class, ProjectDaoImpl.class);
  }

  public static DaoFactory getInstance() {
    return instance;
  }

  public synchronized <T> T getDao(Class<T> daoType) {
    try {
      Class<?> implType = typeMap.get(daoType);
      T dao = daoType.cast(implType.newInstance());
      return dao;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
