package ua.goit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.factory.ConnectionGetAndFree;
import ua.goit.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {
  private final ConnectionGetAndFree connectionGetAndFree;

  @Autowired
  public CommentDaoImpl(ConnectionGetAndFree connectionGetAndFree) {
    this.connectionGetAndFree = connectionGetAndFree;
  }

  @Override
  public void add(Comment entity) {
    PreparedStatement statement = null;
    String sql = "INSERT INTO Coments (comment, timeStamp, project_id, users_id) VALUES (?,?,?,?)";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setString(1, entity.getComment());
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
  public Comment getById(Integer id) {
    Statement statement = null;
    Comment coment = null;
    String sql = "SELECT id, comment, timestamp, project_id, users_id FROM Coments WHERE id = " + id;
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        coment = getComment(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }
    return coment;
  }


  @Override
  public List<Comment> getAll() {
    Statement statement = null;
    Comment coment = null;
    List<Comment> listWithComment = new ArrayList<Comment>();
    String sql = "SELECT id, comment, timestamp, project_id, users_id FROM Coments";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        coment = getComment(rs);
        listWithComment.add(coment);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }

    return listWithComment;
  }


  @Override
  public void update(Comment entity) {
    PreparedStatement statement = null;
    String sql = "UPDATE Coments SET comment = ?, timestamp = ?, project_id = ?, users_id = ? WHERE id = ?";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setString(1, entity.getComment());
      statement.setTimestamp(2, entity.getTimestamp());
      statement.setInt(3, entity.getProject_id());
      statement.setInt(4, entity.getUsers_id());
      statement.setInt(5, entity.getUsers_id());
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
    String sql = "DELETE FROM Coments WHERE id = ?";
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

  private Comment getComment(ResultSet rs) throws SQLException {
    Integer id = rs.getInt("id");
    String comment = rs.getString("comment");
    Timestamp timestamp = rs.getTimestamp("timeStamp");
    Integer project_id = rs.getInt("project_id");
    Integer users_id = rs.getInt("users_id");

    return new Comment(id, comment, timestamp, project_id, users_id);
  }

}

