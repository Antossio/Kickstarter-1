package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "name")
  private String categoryName;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
  private List<Project> projectList;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Timestamp timestamp;

  public Category(Integer id, String categoryName, Timestamp timestamp) {
    this.id = id;
    this.categoryName = categoryName;
    this.timestamp = timestamp;
  }

  public Category(String categoryName) {
    this.categoryName = categoryName;
  }

  public Category() {
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public List<Project> getListOfProject() {
    return projectList;
  }

  public void setListOfProject(List<Project> projectList) {
    this.projectList = projectList;
  }

}
