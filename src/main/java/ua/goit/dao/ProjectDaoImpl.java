package ua.goit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.goit.model.Project;

import java.util.List;

@Repository

public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {

  ProjectDaoImpl() {
    super(Project.class);
  }

  @Override
  public List<Project> getProjectsByUserId(Integer id) {
    String sql = "from Project where User_id =:User_id";
    Query query = getQuery(sql);
    List<Project> list = query.setParameter("User_id", id).list();
    return list;
  }

  @Override
  public List<Project> getProjectsByCategoryId(Integer id) {
    String sql = "from Project where Category_id =:Category_id";
    Query query = getQuery(sql);
    List<Project> list = query.setParameter("Category_id", id).list();
    return list;
  }

  private Query getQuery(String sql) {
    Session currentSession = sessionFactory.getCurrentSession();
    return currentSession.createQuery(sql);
  }

}

