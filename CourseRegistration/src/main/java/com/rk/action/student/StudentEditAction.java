package com.rk.action.student;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Course;
import com.rk.dto.Student;

public class StudentEditAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentService studentService;

	private Student student;

	private String sId;

	List<Course> studentCourseDetails;

	private String totalCredits;

	public String execute() {
		Integer studentId = Integer.valueOf(sId);
		student = studentService.getStudentDetailsWithID(studentId);
		int totalValue = getTotalCredits(student);
		totalCredits = Integer.valueOf(totalValue).toString();
		return SUCCESS;
	}

	private int getTotalCredits(Student student) {
		int totalCredits = 0;
		Set<Course> courses = student.getCourses();
		for (Course course : courses) {
			if (course != null) {
				totalCredits = totalCredits + course.getcCredits();
			}
		}
		return totalCredits;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Course> getStudentCourseDetails() {
		return studentCourseDetails;
	}

	public void setStudentCourseDetails(List<Course> studentCourseDetails) {
		this.studentCourseDetails = studentCourseDetails;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}
}
