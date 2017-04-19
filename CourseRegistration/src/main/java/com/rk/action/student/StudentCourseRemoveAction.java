package com.rk.action.student;

import java.util.ArrayList;
import java.util.List;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Course;
import com.rk.dto.Student;
//import com.rk.mail.MailUtil;

public class StudentCourseRemoveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentService studentService;

	private String sId;

	private Student student;

	List<Course> studentCourseDetails = new ArrayList<>();

	List<String> selectedRemCourseList;

	@Override
	public String execute() {
		student = studentService.getStudentDetailsWithID(Integer.valueOf(sId));
		studentCourseDetails.addAll(student.getCourses());
		return SUCCESS;
	}

	public String removeStudentCourses() {
		studentService.removeStudentCourses(Integer.valueOf(sId), selectedRemCourseList);
		// sendMail(sId);
		return SUCCESS;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
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

	public List<String> getSelectedRemCourseList() {
		return selectedRemCourseList;
	}

	/*
	 * private void sendMail(String sId) { List<Course> studentCourseDetails =
	 * studentDao.getStudentCourseDetails(Integer.valueOf(sId)); Student
	 * studentDetailsWithID =
	 * studentDao.getStudentDetailsWithID(Integer.valueOf(sId)); try {
	 * MailUtil.generateAndSendEmail(studentDetailsWithID,
	 * studentCourseDetails); } catch (AddressException e) {
	 * e.printStackTrace(); } catch (MessagingException e) {
	 * e.printStackTrace(); } }
	 */

	public void setSelectedRemCourseList(List<String> selectedRemCourseList) {
		this.selectedRemCourseList = selectedRemCourseList;
	}
}
