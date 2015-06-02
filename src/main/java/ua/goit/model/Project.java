package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Category_id")
  private Category category;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Users_id")
  private Users users;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Timestamp timestamp;
  private String shortDesc;
  private String longDesc;
  private String link;
  private int likesQty;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
  private List<Comment> commentList;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
  private List<AuthorBlog> postList;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
  private List<Like> likeList;
  

  public Project() {
  }

  public Project(String name, Category category, Users users, String shortDesc, String longDesc, String link) {
    this.name = name;
    this.category = category;
    this.users = users;
    this.shortDesc = shortDesc;
    this.longDesc = longDesc;
    this.link = link;
    this.likesQty = 0;
  }

  public List<Like> getLikeList() {
    return likeList;
  }
  
  public List<AuthorBlog> getPostList() {
    return postList;
  }
  
  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String projectName) {
    this.name = projectName;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public String getShortDesc() {
    return shortDesc;
  }

  public void setShortDesc(String shortDesc) {
    this.shortDesc = shortDesc;
  }

  public String getLongDesc() {
    return longDesc;
  }

  public void setLongDesc(String longDesc) {
    this.longDesc = longDesc;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
  
  public void setLikesQty(int likesQty) {
    this.likesQty = likesQty;
  }
  
  public int getLikesQty() {
    return likesQty;
  }  
}
