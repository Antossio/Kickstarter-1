package ua.goit.dao;

import java.util.List;

import ua.goit.model.Comment;

public interface CommentDao extends GenericDao<Comment> {

  List<Comment> getAllByProjectId(Integer id);  
}