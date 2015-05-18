package ua.goit.dao;

import org.springframework.stereotype.Repository;
import ua.goit.model.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
  
  public CategoryDaoImpl() {
    super(Category.class);
  }
}