package com.rk.action.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.dto.Student;

public class StudentDeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentService studentService;

	List<Student> studentList;

	List<String> selectedStudentList;

	@Override
	public String execute() {
		studentList = studentService.getAllStudentDetails();
		return SUCCESS;
	}

	public String deleteStudents() {
		studentService.deleteStudent(selectedStudentList);
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<String> getSelectedStudentList() {
		return selectedStudentList;
	}

	public void setSelectedStudentList(List<String> selectedStudentList) {
		this.selectedStudentList = selectedStudentList;
	}

}
