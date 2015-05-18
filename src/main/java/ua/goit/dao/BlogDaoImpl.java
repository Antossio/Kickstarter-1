package ua.goit.dao;

import org.springframework.stereotype.Repository;
import ua.goit.model.AuthorBlog;

@Repository
public class BlogDaoImpl extends GenericDaoImpl<AuthorBlog> implements BlogDao {

  public BlogDaoImpl() {
    super(AuthorBlog.class);
  }
}