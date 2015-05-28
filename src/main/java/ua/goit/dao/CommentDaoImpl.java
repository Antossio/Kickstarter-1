package ua.goit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.goit.model.Comment;
import ua.goit.model.Project;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

  CommentDaoImpl() {
    super(Comment.class);
  }

  @Override
  public List<Comment> getAllByProjectId(Integer id) {
    String sql = "from Coments where Project_id =:Project_id";
    Query query = getQuery(sql);
    List<Comment> list = query.setParameter("Project_id", id).list();
    return list;    
  }
  
  private Query getQuery(String sql) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.createQuery(sql);
  }
}