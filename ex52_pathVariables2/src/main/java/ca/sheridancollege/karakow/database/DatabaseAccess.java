package ca.sheridancollege.karakow.database;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.karakow.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
//	public void insertStudent() {
//		
//		String query="INSERT INTO student(name) VALUES('Frank')";
//		
//		int rowsAffected = jdbc.update(query, new HashMap());
//		
//		if (rowsAffected > 0) {
//			System.out.println("Inserted student into database");
//		}
//	}
	
	public void insertStudent(String name) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query="INSERT INTO student(name) "
				+ "VALUES(:name)";
		
		namedParameters.addValue("name", name);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if (rowsAffected > 0) {
			System.out.println("Inserted student into database");
		}
	}
	
	public List<Student> getStudents(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "Select * from student";
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Student>(Student.class));
		
	}
	
	public void deleteStudent(Long id) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "DELETE FROM Student WHERE id = :id";
		
		namedParameters.addValue("id", id); //Query is completed
		
		int rowsAffected = jdbc.update(query, namedParameters);// execution of the query
		
		if(rowsAffected > 0) {
			System.out.println("Student deleted from the database.");
		}
	}
	
	public List<Student> getStudentById(Long id) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM student WHERE id = :id"; 
		
		namedParameters.addValue("id", id);
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Student>(Student.class));
		
	}
	
	public void updateStudent(Long id, String name) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "UPDATE student SET name = :name WHERE id= :id";
		
		namedParameters.addValue("id", id); //Query is completed
		namedParameters.addValue("name", name);
		
		int rowsAffected = jdbc.update(query, namedParameters);// execution of the query
		
		if(rowsAffected > 0) {
			System.out.println("Student updated in the database.");
		}
	}
	
	
	
	
}
