package com.rk.action.student;

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
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Student> getAllStudentDetails() {
		return studentDao.getAllStudentDetails();
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addUpdateStudentCourses(student);
	}

	@Override
	public void addStudentCourses(Student student, List<Integer> courseList) {
		Student studentUpdate = studentDao.getStudentDetailsWithID(student.getsId());
		for (Integer id : courseList) {
			studentUpdate.addCourse(courseDao.getCourseWithId(id));
		}
		studentDao.addUpdateStudentCourses(studentUpdate);
	}

	@Override
	public Student getStudentDetailsWithID(Integer studentID) {
		return studentDao.getStudentDetailsWithID(studentID);
	}

	@Override
	public void removeStudentCourses(Integer studentId, List<String> selectedRemCourseList) {
		Student student = studentDao.getStudentDetailsWithID(studentId);
		if (selectedRemCourseList != null) {
			for (String courseID : selectedRemCourseList) {
				if (!courseID.equalsIgnoreCase("false")) {
					Course course = courseDao.getCourseWithId(Integer.parseInt(courseID));
					student.getCourses().remove(course);
				}
			}
		}
		studentDao.addUpdateStudentCourses(student);
	}

	@Override
	public void deleteStudent(List<String> studentIdList) {
		if (studentIdList != null) {
			// selectedStudentList
			for (String studentId : studentIdList) {
				if (!studentId.equalsIgnoreCase("false")) {
					Student student = studentDao.getStudentDetailsWithID(Integer.parseInt(studentId));
					studentDao.deleteStudent(student);
				}
			}
		}
	}

}
