package pl.coderslab.examples.programmingschool.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Groups {
	private int id;
	private String name;
	
	Groups(String name) {
		this.name=name;
	}
	
	Groups() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void saveToDB(Connection	conn) throws SQLException {
	if	(this.id == 0) {
		String sql = "INSERT INTO User_group(name) VALUES (?);";
		String generatedColumns[] = {"ID"};
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql, generatedColumns);
		preparedStatement.setString(1, this.name);
		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if	(rs.next())	{
			this.id	= rs.getInt(1);
		}
		preparedStatement.close();
		}
	}

	static public Groups loadGroupById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM	User_group where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
				Groups loadedGroups = new Groups();
				loadedGroups.id = resultSet.getInt("id");
				loadedGroups.name	= resultSet.getString("name");
				return	loadedGroups;
		}
		return	null;
	}
	
	static	public	Groups[] loadAllGroups(Connection conn) throws SQLException	{
		ArrayList<Groups>	groups = new ArrayList<Groups>();
		String	sql	= "SELECT * FROM User_group";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
				Groups loadedGroups	= new Groups();
				loadedGroups.id	=	resultSet.getInt("id");
				loadedGroups.name	=	resultSet.getString("name");
				groups.add(loadedGroups);
		}
		Groups[]	uArray	=	new	Groups[groups.size()];
		uArray	=	groups.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn) throws SQLException	{
		if (this.id != 0) {
			String	sql	= "DELETE FROM User_group WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, this.id);
			preparedStatement.executeUpdate();
			this.id=0;
		}
	}

}
