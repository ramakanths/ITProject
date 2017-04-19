package com.rk.action.course;

import java.util.List;

import com.rk.dto.Course;

public interface CourseService {

	public List<Course> getAllCourses();

	public void addCourse(Course course);

	public void deleteCourse(List<String> courseList);

}
