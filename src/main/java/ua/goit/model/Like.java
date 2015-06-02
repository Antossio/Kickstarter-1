package ua.goit.model;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Likes")
public class Like {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Project_id")
  private Project project;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Users_id")
  private Users users;
 
  public Like() {    
  }
  
  public Like(Project project, Users users) {
    this.users = users;
    this.project = project;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public int getId() {
    return id;
  }
  
  public Users getUsers() {
    return users;
  }

  public Project getProject() {
    return project;
  }
}
