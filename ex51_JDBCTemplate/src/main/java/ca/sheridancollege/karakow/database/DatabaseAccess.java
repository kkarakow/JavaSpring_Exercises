package ca.sheridancollege.karakow.database;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.karakow.beans.Province;
import ca.sheridancollege.karakow.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertStudent() {
		String query = "INSERT INTO student(name) VALUES ('Frank')";
		int rowsAffected = jdbc.update(query, new HashMap());
		if(rowsAffected > 0)
			System.out.println("Inserted student into database.");
		
	}
	
	public void insertStudent(String name, Long houseNumber, 
			String streetName, String city, String province) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query="INSERT INTO Student(name, houseNumber, streetName, city, province) "
				+ "VALUES(:name, :houseNumber, :streetName, :city, :province)";
		
		namedParameters.addValue("name", name);
		namedParameters.addValue("houseNumber", houseNumber);
		namedParameters.addValue("streetName", streetName);
		namedParameters.addValue("city", city);
		namedParameters.addValue("province", province);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if (rowsAffected > 0) {
			System.out.println("Inserted student into database");
		}
	}
	
	public List<Student> getStudents(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "Select * from Student";
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Student>(Student.class));
		
		
	}
	
	public List<Province> getProvinces(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "Select * from Provinces";
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Province>(Province.class));
		
		
	}
	
	
	
	
}
