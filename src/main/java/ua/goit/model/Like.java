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
  private User user;
 
  public Like() {    
  }
  
  public Like(Project project, User user) {
    this.user = user;
    this.project = project;
  }

  public int getId() {
    return id;
  }
  
  public User getUser() {
    return user;
  }

  public Project getProject() {
    return project;
  }
}
