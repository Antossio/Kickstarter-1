package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String login;
    private String password;
    private String token;
    private Timestamp timestamp;
    private String email;
    private Integer activeFlag;
    private String activationKey;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Project> projectList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY, mappedBy = "user")
    private List<AuthorBlog> authorBlogsList;

    public User(Integer id, String name, String login, String password, String token, Timestamp timestamp, List<AuthorBlog> authorBlogsList) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.token = token;
        this.timestamp = timestamp;
        this.authorBlogsList = authorBlogsList;
    }

    public User(String name, String login, String password, String email, String activationKey) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.activationKey = activationKey;
        this.token = "0";
        this.activeFlag = 0;
    }

    public User(Integer id, String name, String login, String password, String token, Timestamp timestamp, String email, String activationKey, Integer activeFlag) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.token = token;
        this.timestamp = timestamp;
        this.email = email;
        this.activationKey = activationKey;
        this.activeFlag = activeFlag;
    }

    public User() {
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer isActive() {
        return activeFlag;
    }

    public void setIsActive(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
}
