package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class AuthorBlog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String blog;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Timestamp timestamp;
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "Project_id")
  private Project project;
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "Users_id")
  private Users users;

  public AuthorBlog(String blog, Project project, Users users) {
    this.blog = blog;
    this.project = project;
    this.users = users;
  }

  public AuthorBlog() {
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBlog() {
    return blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}