package ua.goit.dao;

import ua.goit.model.Like;

import java.util.List;

public interface LikeDao extends GenericDao<Like> {
  List<Like> getLikesByProductId(Integer categoryId);
}
