package ua.goit.model;

import java.sql.Timestamp;

public class Project {
	private Integer id;
	private String projectName;
	private Category category;
	private User user;
	private Timestamp timestamp;
	private String shortDesc;
	private String longDesc;
	private String link;

	public Project(String projectName, Category category,
			User user, String shortDesc, String longDesc, String link) {
		this.projectName = projectName;
		this.category = category;
		this.user = user;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.link = link;
	}

	public Project(Integer id, String projectName, Category category,
			User user, Timestamp timestamp, String shortDesc, String longDesc, String link) {
		this.id = id;
		this.projectName = projectName;
		this.category = category;
		this.user = user;
		this.timestamp = timestamp;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.link = link;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public String getLink() {
		return link;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProjectName() {
		return projectName;
	}
}
