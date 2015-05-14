package ua.goit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.model.AuthorBlog;

@Repository
public class BlogDaoImpl extends GenericDaoImpl<AuthorBlog> implements BlogDao {

  public BlogDaoImpl() {
    super(AuthorBlog.class);
  }
}
