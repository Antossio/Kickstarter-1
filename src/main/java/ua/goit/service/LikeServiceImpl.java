package ua.goit.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dao.LikeDao;
import ua.goit.model.Like;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LikeServiceImpl implements LikeService{

  private final LikeDao likeDao;

  @Autowired
  public LikeServiceImpl(LikeDao likeDao) {
    this.likeDao = likeDao;
  }

  @Override
  public void add(Like entity) {
   likeDao.add(entity);
    
  }

  @Override
  public Like getById(Integer id) {
    Like like = likeDao.getById(id);
    Hibernate.initialize(like.getUser());
    return like;
  }

  @Override
  public List<Like> getAll() {
   return null;
  }

  @Override
  public void update(Like entity) {
        
  }

  @Override
  public void remove(Integer id) {
    likeDao.remove(id);
  }

  @Override
  public List<Like> getAllByProjectId(Integer id) {
    List <Like> likes = likeDao.getLikesByProductId(id);    
    return likes;
  } 
  
}
