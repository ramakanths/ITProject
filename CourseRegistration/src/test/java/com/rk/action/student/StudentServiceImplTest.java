package com.rk.action.student;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.rk.course.dao.CourseDaoImpl;
import com.rk.dto.Course;
import com.rk.dto.Student;
import com.rk.student.dao.StudentDaoImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@Mock
	StudentDaoImpl studentDao;

	@Mock
	CourseDaoImpl courseDao;

	@InjectMocks
	StudentServiceImpl studentService;

	List<Student> students = new ArrayList<>();
	List<Integer> courseList = new ArrayList<>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		students.add(getxyzStudent());
		courseList.add(100);
		courseList.add(101);
	}

	@Test
	public void testGetAllStudentDetails() {
		when(studentDao.getAllStudentDetails()).thenReturn(students);
		List<Student> allStudentDetails = studentService.getAllStudentDetails();
		Assert.assertNotNull(allStudentDetails);

	}

	@Test
	public void testAddStudentCourses() {
		Student student = getxyzStudent();
		student.setsId(500);
		when(studentDao.getStudentDetailsWithID(student.getsId())).thenReturn(student);
		when(courseDao.getCourseWithId(anyInt())).thenReturn(getJavaCourse());
		studentService.addStudentCourses(student, courseList);
	}

	@Test
	public void testRemoveStudentCourses() {
		when(studentDao.getStudentDetailsWithID(anyInt())).thenReturn(getxyzStudent());
		when(courseDao.getCourseWithId(anyInt())).thenReturn(getJavaCourse());
		String courses[] = new String[] { "100", "101" };
		studentService.removeStudentCourses(500, Arrays.asList(courses));
	}

	@Test
	public void testDeleteStudent() {
		when(studentDao.getStudentDetailsWithID(anyInt())).thenReturn(anyObject());
		String students[] = new String[] { "500", "501" };
		studentService.deleteStudent(Arrays.asList(students));
	}

	public Student getxyzStudent() {
		Student student = new Student();
		student.setsName("xyz");
		student.setsEmail("xyz@gmail.com");
		return student;
	}

	public Course getJavaCourse() {
		Course course = new Course();
		course.setcName("JAVA");
		course.setcWeekName("Monday");
		course.setcTime("11:00");
		course.setcCredits(4);
		return course;
	}
}
