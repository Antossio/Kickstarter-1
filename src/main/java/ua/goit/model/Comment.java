package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "coments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "comment")
	private String comment;
	@Column(name = "timeStamp")
	private Timestamp timestamp;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Project_id")
	private Project project_id;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Users_id")
	private User users_id;

	public Comment(Integer id, String comment, Timestamp timestamp,
			Project project_id, User users_id) {
		super();
		this.id = id;
		this.comment = comment;
		this.timestamp = timestamp;
		this.project_id = project_id;
		this.users_id  = users_id;
	}

	public Comment(String comment, Project project_id, User users_id) {
		super();
		this.comment = comment;
		this.project_id = project_id;
		this.users_id = users_id;
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
	public Project getProject_id() {
		return project_id;
	}
	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}
	public User getUsers_id() {
		return users_id;
	}
	public void setUsers_id(User users_id) {
		this.users_id = users_id;
	}

}
