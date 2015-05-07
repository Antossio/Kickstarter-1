package ua.goit.service;

import java.util.List;

import ua.goit.dao.CommentDao;
import ua.goit.model.Comment;

public class CommentServiceImpl implements CommentService {
	private final CommentDao commentDao;

	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public void add(Comment entity) {
		commentDao.add(entity);
	}

	@Override
	public Comment getById(Integer id) {
		return commentDao.getById(id);
	}

	@Override
	public List<Comment> getAll() {
		return commentDao.getAll();
	}

	@Override
	public void update(Comment entity) {
		commentDao.update(entity);		
	}

	@Override
	public void remove(Integer id) {
		commentDao.remove(id);

	}

}