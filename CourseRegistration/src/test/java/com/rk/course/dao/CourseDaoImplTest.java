package com.rk.course.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.rk.dto.Course;
import com.rk.student.dao.CommonTest;

public class CourseDaoImplTest extends CommonTest {

	@Test
	public void testGetCourseDetails() {
		List<Course> courseDetails = courseDao.getCourseDetails();
		Assert.assertNotNull(courseDetails);
	}

	@Test
	public void testGetCoursesWithId() {
		Course coursesWithId = courseDao.getCourseWithId(courseId);
		Assert.assertNotNull(coursesWithId);
	}

	@Test
	public void testDeleteCourse() {
		List<Course> courseDetails = courseDao.getCourseDetails();
		Course course = courseDetails.get(0);
		Integer courseId = course.getcId();
		
		courseDao.deleteCourse(course);
		Course deletedCourse = courseDao.getCourseWithId(courseId);
		Assert.assertNull(deletedCourse);

	}
	/*
	 * @Test public void deleteCoursewithStudentsTest() { Course courses100 =
	 * courseDao.getCourseWithId(100); Course courses101 =
	 * courseDao.getCourseWithId(101); Student student = getStudent();
	 * Set<Course> courses = new HashSet<>(); courses.add(courses101);
	 * courses.add(courses100); student.setCourses(courses);
	 * 
	 * studentDao.addUpdateStudentCourses(student);
	 * 
	 * List<Student> allStudentDetails = studentDao.getAllStudentDetails();
	 * System.out.println("allStudentDetails"+allStudentDetails); Course
	 * courseDelete = courseDao.getCourseWithId(100); for (Student std :
	 * courseDelete.getStudents()) { std.getCourses().remove(courseDelete); }
	 * 
	 * courseDao.deleteCourse(courseDelete); List<Student> allStudentDetails2 =
	 * studentDao.getAllStudentDetails();
	 * System.out.println("allStudentDetails2"+allStudentDetails2);
	 * 
	 * Course courseDelete2 = courseDao.getCourseWithId(100);
	 * System.out.println("courseDelete2=="+courseDelete2);
	 * 
	 * }
	 */
}
