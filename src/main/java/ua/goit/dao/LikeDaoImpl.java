package ua.goit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.goit.model.Like;
import ua.goit.model.Project;
import ua.goit.model.User;

@Repository
public class LikeDaoImpl extends GenericDaoImpl<Like> implements LikeDao{

  LikeDaoImpl() {
    super(Like.class);   
  }

  @Override
  public List<Like> getLikesByProductId(Integer id) {
    String sql = "from Like where Project_id =:Project_id";
    Query query = getQuery(sql);
    List<Like> list = query.setParameter("Project_id", id).list();
    return list;
  }

  private Query getQuery(String sql) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.createQuery(sql);
  }
}
