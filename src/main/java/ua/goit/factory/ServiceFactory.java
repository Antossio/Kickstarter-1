package ua.goit.factory;

import ua.goit.service.*;
import ua.goit.service.CategoryServiceImpl;
import ua.goit.service.ProjectService;
import ua.goit.service.ProjectServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
  private final static ServiceFactory instance = new ServiceFactory();
  private Map<Class<?>, Class<?>> typeMap;

  private ServiceFactory() {
    typeMap = new HashMap<>();
    typeMap.put(CategoryService.class, CategoryServiceImpl.class);
    typeMap.put(ProjectService.class, ProjectServiceImpl.class);
  }
  public static ServiceFactory getInstance() {
    return instance;
  }

  public synchronized <T> T getService(Class<T> serviceType) {
    try {
      Class<?> implType = typeMap.get(serviceType);
      T service = serviceType.cast(implType.newInstance());
      return service;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
