package com.rk.action.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rk.course.dao.CourseDao;
import com.rk.dto.Course;
import com.rk.dto.Student;
import com.rk.student.dao.StudentDao;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Course> getAllCourses() {
		return courseDao.getCourseDetails();
	}

	@Override
	public void addCourse(Course course) {
		courseDao.insertCourse(course);
	}

	@Override
	public void deleteCourse(List<String> courseList) {
		if (courseList != null) {
			for (String courseId : courseList) {
				if (!courseId.equalsIgnoreCase("false")) {
					Course course = courseDao.getCourseWithId(Integer.parseInt(courseId));
					for (Student student : course.getStudents()) {
						student.getCourses().remove(course);
						// hibernate will update the student course join table
						// but somehow failing, needs to figure it out.
						// for testing added below code
						studentDao.addUpdateStudentCourses(student);
					}
					courseDao.deleteCourse(course);
				}
			}
		}
	}
}
