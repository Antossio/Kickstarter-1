package ua.goit.model;

import java.sql.Timestamp;

public class Blog {
	private Integer id;
	private String blog;
	private Timestamp timestamp;
	private Integer project_id;
	private Integer users_id;

	public Blog(Integer id, String blog, Timestamp timestamp,
			Integer project_id, Integer users_id) {
		this.id = id;
		this.blog = blog;
		this.timestamp = timestamp;
		this.project_id = project_id;
		this.users_id = users_id;
	}

	public Blog(String blog, Integer project_id, Integer users_id) {
		super();
		this.blog = blog;
		this.project_id = project_id;
		this.users_id = users_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
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