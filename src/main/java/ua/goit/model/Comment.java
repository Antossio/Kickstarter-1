package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Coments")
public class Comment implements Comparable<Comment> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "comment")
  private String comment;
  @Column(name = "timeStamp")
  private Timestamp timestamp;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Project_id")
  private Project project;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "Users_id")
  private Users users;

  public Comment(Integer id, String comment, Timestamp timestamp, Project project, Users users) {
    super();
    this.id = id;
    this.comment = comment;
    this.timestamp = timestamp;
    this.project = project;
    this.users = users;
  }

  public Comment(String comment, Project project, Users users) {
    super();
    this.comment = comment;
    this.project = project;
    this.users = users;

  }

  public Comment() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  public void setProject(Project project_id) {
    this.project = project_id;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  @Override
  public int compareTo(Comment o1) {
    if (this.timestamp.before(o1.timestamp)) {
      return 1;
    } else {
      return -1;
    }
  }
}