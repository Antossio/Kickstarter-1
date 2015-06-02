package ua.goit.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String role;
  @ManyToOne(cascade = CascadeType.ALL)
  private Users users;

  public UserRole() {
  }

  public UserRole(Role role, Users users) {
    this.role = role.toString();
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
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
