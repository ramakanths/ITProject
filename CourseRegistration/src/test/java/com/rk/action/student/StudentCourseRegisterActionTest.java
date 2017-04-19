package com.rk.action.student;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.rk.action.course.CourseServiceImpl;
import com.rk.dto.Course;
import com.rk.dto.Student;



@RunWith(MockitoJUnitRunner.class)
public class StudentCourseRegisterActionTest {

	@Mock
	CourseServiceImpl courseService;

	@Mock
	StudentServiceImpl studentService;

	List<Course> courseDetails = new ArrayList<>();

	@InjectMocks
	StudentCourseRegisterAction action;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		courseDetails.add(getJavaCourse());
		courseDetails.add(getJSPCourse());
	}

	@Test
	public void testValidationwithIncorrect() {
		when(courseService.getAllCourses()).thenReturn(courseDetails);
		when(studentService.getStudentDetailsWithID(anyInt())).thenReturn(getxyzStudent());
		action.validate();
		Assert.assertTrue(action.getActionErrors().size()==0);
	}

	public Course getJavaCourse() {
		Course course = new Course();
		course.setcId(100);
		course.setcName("JAVA");
		course.setcWeekName("Monday");
		course.setcTime("11:00");
		course.setcCredits(4);
		return course;
	}

	public Course getJSPCourse() {
		Course course = new Course();
		course.setcId(101);
		course.setcName("JSP");
		course.setcWeekName("Tuesday");
		course.setcTime("11:00");
		course.setcCredits(4);
		return course;
	}

	public Student getxyzStudent() {
		Student student = new Student();
		student.setsId(500);
		student.setsName("xyz");
		student.setsEmail("xyz@gmail.com");
		student.addCourse(getJavaCourse());
		return student;
	}
}
