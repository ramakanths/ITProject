package com.rk.action.course;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;
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

import com.rk.course.dao.CourseDaoImpl;
import com.rk.dto.Course;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

	@InjectMocks
	CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

	@Mock
	CourseDaoImpl courseDao;

	List<Course> courseList = new ArrayList<>();

	List<String> courseId = new ArrayList<>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		courseList.add(getJavaCourse());
		courseId.add("100");
		courseId.add("false");
	}

	@Test
	public void testGetAllCourses() {
		when(courseDao.getCourseDetails()).thenReturn(courseList);
		List<Course> allCourses = courseServiceImpl.getAllCourses();
		Assert.assertNotNull(allCourses);
	}

	@Test
	public void deleteCourse() {
		Course course = getJavaCourse();
		when(courseDao.getCourseWithId(anyInt())).thenReturn(course);
		courseServiceImpl.deleteCourse(courseId);
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
