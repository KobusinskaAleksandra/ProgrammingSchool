package pl.coderslab.examples.programmingschool.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class Solution {
	private int id;
	private Date created; 
	private Date updated; 
	private String description;
	private int exercise_id;
	private int users_id;
	
	
	public Solution (Date created, Date updated, String description, int exercise_id, int users_id) {
		this.created=created;
		this.updated=updated;
		this.description=description;
		this.exercise_id=exercise_id;
		this.users_id=users_id;
	}
	public Solution() {};

	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getExercise_id() {
		return exercise_id;
	}


	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}


	public int getUsers_id() {
		return users_id;
	}


	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
	public void saveToDB(Connection	conn) throws SQLException {
		if	(this.id == 0) {
			String sql = "INSERT INTO Solution(create, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?);";
			String generatedColumns[] = {"ID"};
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns); 
			preparedStatement.setDate(1, this.created);
			preparedStatement.setDate(2, this.updated);
			preparedStatement.setString(3, this.description);
			preparedStatement.setInt(1, this.exercise_id);
			preparedStatement.setInt(1, this.users_id);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if	(rs.next())	{
				this.id	= rs.getInt(1);
			}
			preparedStatement.close();
			}
		}

		static public Solution loadSolutionById(Connection conn, int id) throws SQLException {
			String sql = "SELECT * FROM	Solution where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Solution loadedSolution = new Solution();
					loadedSolution.created = resultSet.getDate("created");
					loadedSolution.updated = resultSet.getDate("updated");
					loadedSolution.description	= resultSet.getString("description");
					loadedSolution.exercise_id = resultSet.getInt("exercise_id");
					loadedSolution.users_id	= resultSet.getInt("users_id");
					return	loadedSolution;
			}
			return	null;
		}
		
		static	public Solution[] loadAllSolution(Connection conn) throws SQLException	{
			ArrayList<Solution> solution = new ArrayList<Solution>();
			String	sql	= "SELECT * FROM Solution";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedSolution = new Solution();
				loadedSolution.created = resultSet.getDate("created");
				loadedSolution.updated = resultSet.getDate("updated");
				loadedSolution.description	= resultSet.getString("description");
				loadedSolution.exercise_id = resultSet.getInt("exercise_id");
				loadedSolution.users_id	= resultSet.getInt("users_id");
				solution.add(loadedSolution);
			}
			Solution[]	uArray	=	new	Solution[solution.size()];
			uArray	=	solution.toArray(uArray);
			return uArray;
		}

		public void delete(Connection conn) throws SQLException	{
			if (this.id != 0) {
				String	sql	= "DELETE FROM Solution WHERE id= ?";
				PreparedStatement preparedStatement;
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, this.id);
				preparedStatement.executeUpdate();
				this.id=0;
			}
		}		

		static public Solution[] loadAllByUserId (Connection conn, int id) throws SQLException	{
			ArrayList<Solution> userSolution = new ArrayList<Solution>();
			String	sql	= "SELECT * FROM Solution where user_id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedUserSolution = new Solution();
					loadedUserSolution.id = resultSet.getInt("id");
					loadedUserSolution.created = resultSet.getDate("created");
					loadedUserSolution.updated = resultSet.getDate("updated");
					loadedUserSolution.description = resultSet.getString("description");
					loadedUserSolution.exercise_id = resultSet.getInt("exercise_id");
					loadedUserSolution.users_id = resultSet.getInt("users_id");
					userSolution.add(loadedUserSolution);
			}
			Solution[]	uArray	=	new	Solution[userSolution.size()];
			uArray	=	userSolution.toArray(uArray);
			return uArray;
		}
		
		

		static public Solution[] loadAllByExerciseId (Connection conn, int id) throws SQLException	{
			ArrayList<Solution> exerciseSolution = new ArrayList<Solution>();
			String	sql	= "SELECT * FROM Solution where user_id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Solution loadedExerciseSolution = new Solution();
					loadedExerciseSolution.id = resultSet.getInt("id");
					loadedExerciseSolution.created = resultSet.getDate("created");
					loadedExerciseSolution.updated = resultSet.getDate("updated");
					loadedExerciseSolution.description = resultSet.getString("description");
					loadedExerciseSolution.exercise_id = resultSet.getInt("exercise_id");
					loadedExerciseSolution.users_id = resultSet.getInt("users_id");
					exerciseSolution.add(loadedExerciseSolution);
			}
			Solution[]	uArray	=	new	Solution[exerciseSolution.size()];
			uArray	=	exerciseSolution.toArray(uArray);
			return uArray;
			}
}
		
		
		
		