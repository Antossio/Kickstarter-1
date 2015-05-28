package ua.goit.service;

import java.util.List;

import ua.goit.model.Comment;

public interface CommentService extends GenericService<Comment> {
  
  List <Comment> getAllByProjectId(Integer id);
}
