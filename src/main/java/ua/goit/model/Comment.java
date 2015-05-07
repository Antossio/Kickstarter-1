package ua.goit.model;

import java.sql.Timestamp;

public class Comment {
	private Integer id;
	private String comment;
	private Timestamp timestamp;
	private Integer project_id;
	private Integer users_id;

	public Comment(Integer id, String comment, Timestamp timestamp,
			Integer project_id, Integer users_id) {
		super();
		this.id = id;
		this.comment = comment;
		this.timestamp = timestamp;
		this.project_id = project_id;
		this.users_id = users_id;
	}

	public Comment(String comment, Integer project_id, Integer users_id) {
		super();
		this.comment = comment;
		this.project_id = project_id;
		this.users_id = users_id;
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
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public Integer getUsers_id() {
		return users_id;
	}
	public void setUsers_id(Integer users_id) {
		this.users_id = users_id;
	}

}
