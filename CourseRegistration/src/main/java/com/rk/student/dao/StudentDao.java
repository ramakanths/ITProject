package com.rk.student.dao;

import java.util.List;

import com.rk.dto.Student;

public interface StudentDao {

	public List<Student> getAllStudentDetails();

	public Student getStudentDetailsWithID(Integer studentID);

	public void addUpdateStudentCourses(Student Student);

	public void deleteStudent(Student student);

}
