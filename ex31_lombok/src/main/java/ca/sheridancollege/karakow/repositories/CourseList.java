package ca.sheridancollege.karakow.repositories;

import java.util.List;

import ca.sheridancollege.karakow.beans.Course;

public interface CourseList {

	public List<Course> getCourseList();
	public void setCourseList(List<Course> courseList);
	public void emptyList();
}
