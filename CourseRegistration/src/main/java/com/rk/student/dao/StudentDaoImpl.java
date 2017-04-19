package com.rk.student.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rk.dto.Student;
import com.rk.tables.dao.CommonBaseDao;

@Repository
public class StudentDaoImpl extends CommonBaseDao implements StudentDao {

	public List<Student> getAllStudentDetails() {
		return getAll("from Student");
	}

	@Override
	public Student getStudentDetailsWithID(Integer studentID) {
		return getWithId(Student.class, studentID);
	}

	@Override
	public void addUpdateStudentCourses(Student student) {
		saveorUpdate(student);
	}

	@Override
	public void deleteStudent(Student student) {
		delete(student);
	}

}
