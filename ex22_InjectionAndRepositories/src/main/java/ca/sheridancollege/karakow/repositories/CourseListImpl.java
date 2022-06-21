package ca.sheridancollege.karakow.repositories;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;
import ca.sheridancollege.karakow.beans.Course;

@Component
public class CourseListImpl implements CourseList {

	private List<Course> courseList = new CopyOnWriteArrayList<Course>();

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void emptyList() {
		courseList.clear();
	}

}
