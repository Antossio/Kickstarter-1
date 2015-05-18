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
  private User user;

  public AuthorBlog(Integer id, String blog, Timestamp timestamp, Project project, User user) {
    this.id = id;
    this.blog = blog;
    this.timestamp = timestamp;
    this.project = project;
    this.user = user;
  }

  public AuthorBlog() {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User users) {
    this.user = users;
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