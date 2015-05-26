package ua.goit.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRoles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String role;
  @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "userRoles")
  private List<User> users;

  public UserRoles() {
  }

  public UserRoles(Role role, User user) {
    this.role = role.toString();
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Role getRole() {
    return Role.valueOf(role);
  }

  public void setRole(Role role) {
    this.role = role.toString();
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
