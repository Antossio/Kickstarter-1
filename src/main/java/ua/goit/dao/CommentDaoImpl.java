package ua.goit.dao;

import org.springframework.stereotype.Repository;
import ua.goit.model.Comment;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

  CommentDaoImpl() {
    super(Comment.class);
  }
}