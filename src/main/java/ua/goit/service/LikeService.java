package ua.goit.service;

import java.util.List;

import ua.goit.model.Like;
import ua.goit.model.User;

public interface LikeService extends GenericService<Like> {
  
  List <Like> getAllByProjectId(Integer id);

}
