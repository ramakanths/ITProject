package com.rk.action.course;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Course;

public class CourseDeleteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(CourseDeleteAction.class);

	@Autowired
	private CourseService courseService;

	List<Course> courseDetails;

	List<String> selectedCourseList;

	@Override
	public String execute() {
		courseDetails = courseService.getAllCourses();
		logger.info("Courses Delete");
		return SUCCESS;
	}

	public String deleteCourses() {
		courseService.deleteCourse(selectedCourseList);
		return SUCCESS;
	}

	public List<Course> getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(List<Course> courseDetails) {
		this.courseDetails = courseDetails;
	}

	public List<String> getSelectedCourseList() {
		return selectedCourseList;
	}

	public void setSelectedCourseList(List<String> selectedCourseList) {
		this.selectedCourseList = selectedCourseList;
	}

}
