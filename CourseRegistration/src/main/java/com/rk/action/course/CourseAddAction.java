package com.rk.action.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Course;

@Controller
public class CourseAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CourseService courseService;

	private Course course;

	@Override
	public void validate() {
		if (course != null) {
			if (course.getcName() == null || course.getcName().equals("")) {
				addActionError("Course Name is Empty");
			}
			if (course.getcWeekName() == null || course.getcWeekName().equals("-1")) {
				addActionError("Select a Week Day");
			}
			if (course.getcTime() == null || course.getcTime().equals("")) {
				addActionError("Time is Empty");
			}
			if (course.getcCredits() == null) {
				addActionError("Credits is Empty");
			}
			if (course.getcCredits() != null) {
				if (course.getcCredits() < 1 || course.getcCredits() > 4)
					addActionError("Credits should be less than 4");
			}
		}
	}

	@Override
	public String execute() {
		courseService.addCourse(course);
		return SUCCESS;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
