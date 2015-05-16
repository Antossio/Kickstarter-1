package ua.goit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dao.BlogDao;
import ua.goit.model.AuthorBlog;

import javax.transaction.Transactional;

@Transactional
@Service
public class BlogServiceImpl implements BlogService {
  private final BlogDao blogDao;

  @Autowired
  public BlogServiceImpl(BlogDao blogDao) {
    this.blogDao = blogDao;
  }

  @Override
  public void add(AuthorBlog entity) {
    blogDao.add(entity);
  }

  @Override
  public AuthorBlog getById(Integer id) {
    return blogDao.getById(id);
  }

  @Override
  public List<AuthorBlog> getAll() {
    return blogDao.getAll();
  }

  @Override
  public void update(AuthorBlog entity) {
    blogDao.update(entity);
  }

  @Override
  public void remove(AuthorBlog entity) {
    blogDao.remove(entity);
  }
}