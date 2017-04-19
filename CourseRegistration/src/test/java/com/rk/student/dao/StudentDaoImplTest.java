package com.rk.student.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.rk.dto.Course;
import com.rk.dto.Student;

public class StudentDaoImplTest extends CommonTest {

	@Test
	public void testGetAllStudentDetails() {
		List<Student> allStudentDetails = studentDao.getAllStudentDetails();
		Assert.assertNotNull(allStudentDetails);
	}

	@Test
	public void getStudentDetailsWithID() {
		Student student = studentDao.getStudentDetailsWithID(studentId);
		Assert.assertNotNull(student);
	}

	@Test
	public void testAddUpdateStudentCourses() {
		Student student = studentDao.getStudentDetailsWithID(studentId);
		Course course = courseDao.getCourseWithId(courseId);
		student.addCourse(course);

		studentDao.addUpdateStudentCourses(student);
		Student studentupdated = studentDao.getStudentDetailsWithID(studentId);
		Assert.assertNotNull(studentupdated);
		
	}

}
