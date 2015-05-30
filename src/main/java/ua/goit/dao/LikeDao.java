package ua.goit.dao;

import java.util.List;

import ua.goit.model.Like;
import ua.goit.model.Project;
import ua.goit.model.User;

public interface LikeDao extends GenericDao<Like> {
  List<Like> getLikesByProductId(Integer categoryId);
}
