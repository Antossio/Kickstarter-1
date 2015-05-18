package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
  private List<Project> projectList;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Timestamp timestamp;

  public Category(Integer id, String name, Timestamp timestamp) {
	this.id = id;
	this.name = name;
	this.timestamp = timestamp;
  }

  public Category(String name) {
	this.name = name;
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

  public String getName() {
	return name;
  }

  public void setName(String categoryName) {
	this.name = categoryName;
  }

  public List<Project> getListOfProject() {
	return projectList;
  }

  public void setListOfProject(List<Project> projectList) {
	this.projectList = projectList;
  }
}