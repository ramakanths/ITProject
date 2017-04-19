package com.rk.course.dao;

import java.util.List;

import com.rk.dto.Course;

public interface CourseDao {

	public List<Course> getCourseDetails();

	public Course getCourseWithId(Integer courseId);

	public void insertCourse(Course course);

	public void deleteCourse(Course course);

}
