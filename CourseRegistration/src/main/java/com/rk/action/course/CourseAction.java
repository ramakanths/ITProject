package com.rk.action.course;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Course;

@Controller
public class CourseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(CourseAction.class);

	@Autowired
	private CourseService courseService;

	private Course course;

	List<Course> courseDetails = new ArrayList<>();

	@Override
	public String execute() {
		//courseDetails = courseService.getAllCourses();
		//List<Course> courses = new  ArrayList();
		Course c = new Course();
		c.setcId(100);
		c.setcName("aple");
		c.setcCredits(4);
		c.setcTime("11:40");
		c.setcWeekName("friday");
		courseDetails.add(c);
		
		logger.info("Course Action course Details");
		return SUCCESS;
	}

	public String display() {
		return NONE;
	}

	public List<Course> getCourseDetails() {
		return courseDetails;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
