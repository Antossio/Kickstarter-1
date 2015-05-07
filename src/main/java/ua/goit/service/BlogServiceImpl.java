package ua.goit.service;

import java.util.List;

import ua.goit.dao.BlogDao;
import ua.goit.model.Blog;

public class BlogServiceImpl implements BlogService {
	private final BlogDao blogDao;

	public BlogServiceImpl(BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
	@Override
	public void add(Blog entity) {
		blogDao.add(entity);
	}

	@Override
	public Blog getById(Integer id) {
		return blogDao.getById(id);
	}

	@Override
	public List<Blog> getAll() {
		return blogDao.getAll();
	}

	@Override
	public void update(Blog entity) {
		blogDao.update(entity);
	}

	@Override
	public void remove(Integer id) {
		blogDao.remove(id);
	}
}