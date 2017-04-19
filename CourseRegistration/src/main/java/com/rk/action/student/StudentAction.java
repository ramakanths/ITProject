package com.rk.action.student;

import java.util.List;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Student;
//import com.rk.mail.MailUtil;

@Controller
public class StudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentService studentService;

	private Student student;

	List<Student> studentList;

	@Override
	@SkipValidation
	public String execute() {
		studentList = studentService.getAllStudentDetails();
		return SUCCESS;
	}

	@SkipValidation
	public String display() {
		return NONE;
	}

	@Override
	public void validate() {
		if (student != null) {
			if (student.getsName() == null || student.getsName().equals("")) {
				addActionError("Student Name is Empty");
			}
			if (student.getsEmail() == null || student.getsEmail().equals("")) {
				addActionError("Email is Empty");
			}
		}
	}

	public String addStudent() {
		studentService.addStudent(student);
		/*
		 * try { MailUtil.generateAndSendEmail(student,null); } catch
		 * (AddressException e) { e.printStackTrace(); } catch
		 * (MessagingException e) { e.printStackTrace(); }
		 */
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
