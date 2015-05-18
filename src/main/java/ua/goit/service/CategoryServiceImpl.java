package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dao.CategoryDao;
import ua.goit.model.Category;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
  private final CategoryDao categoryDao;

  @Autowired
  public CategoryServiceImpl(CategoryDao categoryDao) {
    this.categoryDao = categoryDao;
  }

  @Override
  public void add(Category entity) {
    categoryDao.add(entity);
  }

  @Override
  public Category getById(Integer id) {
    return categoryDao.getById(id);
  }

  @Override
  public List<Category> getAll() {
    return categoryDao.getAll();
  }

  @Override
  public void update(Category entity) {
    categoryDao.update(entity);
  }

  @Override
  public void remove(Category entity) {
    categoryDao.remove(entity);
  }
}