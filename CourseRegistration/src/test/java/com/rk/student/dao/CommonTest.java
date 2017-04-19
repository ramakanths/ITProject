package com.rk.student.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rk.course.dao.CourseDao;
import com.rk.dto.Course;
import com.rk.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-module.xml" })
@Transactional
public class CommonTest {

	@Autowired
	public StudentDao studentDao;

	@Autowired
	public CourseDao courseDao;

	protected Integer studentId;
	protected Integer courseId;

	@Before
	public void setup() {
		Course java = getJavaCourse();
		Course jsp = getJSPCourse();
		courseDao.insertCourse(java);
		courseDao.insertCourse(jsp);

		Student firstStudent = getxyzStudent();
		firstStudent.addCourse(java);
		firstStudent.addCourse(jsp);

		Student secStudent = getabcStudent();

		studentDao.addUpdateStudentCourses(firstStudent);
		studentDao.addUpdateStudentCourses(secStudent);

		List<Student> allStudentDetails = studentDao.getAllStudentDetails();
		studentId = allStudentDetails.get(0).getsId();

		List<Course> courseDetails = courseDao.getCourseDetails();
		courseId = courseDetails.get(1).getcId();
	}

	@Test
	public void test() {
		// doNothing
	}

	public Course getJavaCourse() {
		Course course = new Course();
		course.setcName("JAVA");
		course.setcWeekName("Monday");
		course.setcTime("11:00");
		course.setcCredits(4);
		return course;
	}

	public Course getJSPCourse() {
		Course course = new Course();
		course.setcName("JSP");
		course.setcWeekName("Tuesday");
		course.setcTime("11:00");
		course.setcCredits(4);
		return course;
	}

	public Student getxyzStudent() {
		Student student = new Student();
		student.setsName("xyz");
		student.setsEmail("xyz@gmail.com");
		return student;
	}

	public Student getabcStudent() {
		Student student = new Student();
		student.setsName("abc");
		student.setsEmail("abc@gmail.com");
		return student;
	}
}
