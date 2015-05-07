package ua.goit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ua.goit.factory.ConnectionGetAndFree;
import ua.goit.model.Blog;

public class BlogDaoImpl implements BlogDao{
	private final ConnectionGetAndFree connectionGetAndFree;

	public BlogDaoImpl(ConnectionGetAndFree connectionGetAndFree) {
		this.connectionGetAndFree = connectionGetAndFree;
	}

	@Override
	public void add(Blog entity) {
		PreparedStatement statement = null;
		String sql = "INSERT INTO AuthorBlog (blog, timeStamp, project_id, users_id) VALUES (?,?,?,?)";
		Connection connection = null;
		try {
			connection = connectionGetAndFree.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getBlog());
			statement.setTimestamp(2, entity.getTimestamp());
			statement.setInt(3, entity.getProject_id());
			statement.setInt(4, entity.getUsers_id());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionGetAndFree.freeConnection(connection);
		}
	}

	@Override
	public Blog getById(Integer id) {
		Statement statement = null;
		Blog blog = null;
		String sql = "SELECT id, blog, timestamp, project_id, users_id FROM AuttorBlog WHERE id = " + id;
		Connection connection = null;
		try {
			connection = connectionGetAndFree.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				blog = getBlog(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionGetAndFree.freeConnection(connection);
		}
		return blog;
	}

	@Override
	public List<Blog> getAll() {
		Statement statement = null;
		Blog blog = null;
		List<Blog> listWithBlog = new ArrayList<>();
		String sql = "SELECT id, blog, timestamp, project_id, users_id FROM AuthorBlog";
		Connection connection = null;
		try {
			connection = connectionGetAndFree.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				blog = getBlog(rs);
				listWithBlog.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionGetAndFree.freeConnection(connection);
		}

		return listWithBlog;
	}

	@Override
	public void update(Blog entity) {
		PreparedStatement statement = null;
		String sql = "UPDATE AuthorBlog SET blog = ?, project_id = ?, users_id = ? WHERE id = ?";
		Connection connection = null;
		try {
			connection = connectionGetAndFree.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getBlog());
			//statement.setTimestamp(2, entity.getTimestamp());
			statement.setInt(3, entity.getProject_id());
			statement.setInt(4, entity.getUsers_id());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionGetAndFree.freeConnection(connection);
		}

	}



	@Override
	public void remove(Integer id) {
		PreparedStatement statement = null;
		String sql = "DELETE FROM AuthorBlog WHERE id = ?";
		Connection connection = null;
		try {
			connection = connectionGetAndFree.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionGetAndFree.freeConnection(connection);
		}

	}
	
	private Blog getBlog(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("id");
		String blog = rs.getString("blog");
		Timestamp timestamp = rs.getTimestamp("timeStamp");
		Integer project_id = rs.getInt("project_id");
		Integer users_id = rs.getInt("users_id");

		return new Blog(id, blog,timestamp, project_id, users_id);
	}

	

}
