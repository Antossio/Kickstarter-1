package ua.goit.service;

import ua.goit.model.Like;

import java.util.List;

public interface LikeService extends GenericService<Like> {
  
  List <Like> getAllByProjectId(Integer id);

}
