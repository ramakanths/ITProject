package com.rk.action.student;

import java.util.List;

import com.rk.dto.Student;

public interface StudentService {

	public List<Student> getAllStudentDetails();

	public void addStudent(Student student);

	public void addStudentCourses(Student student, List<Integer> courseList);

	public Student getStudentDetailsWithID(Integer studentID);

	public void removeStudentCourses(Integer studentID, List<String> courseList);

	public void deleteStudent(List<String> studentIdList);

}
