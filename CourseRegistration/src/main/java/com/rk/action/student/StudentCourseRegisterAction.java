package com.rk.action.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.rk.action.course.CourseService;
import com.rk.dto.Course;
import com.rk.dto.Student;
//import com.rk.mail.MailUtil;

@Controller
public class StudentCourseRegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CourseService courseService;

	private String sId;

	List<Course> courseDetails;

	@Autowired
	private StudentService studentService;

	private List<String> selectedCourseList = new ArrayList<>();

	@Override
	@SkipValidation
	public String execute() {
		return SUCCESS;
	}

	@SkipValidation
	public String display() {
		courseDetails = courseService.getAllCourses();
		return NONE;
	}

	public String addStudentCourse() {
		List<Integer> courseIdList = new ArrayList<>();
		if (selectedCourseList != null) {
			for (String courseID : selectedCourseList) {
				if (!courseID.equalsIgnoreCase("false")) {
					courseIdList.add(Integer.valueOf(courseID));
				}
			}
		}
		Student student = new Student();
		student.setsId(Integer.valueOf(sId));
		studentService.addStudentCourses(student, courseIdList);
		// sendMail(sId);
		return SUCCESS;
	}

	@Override
	public void validate() {
		courseDetails = courseService.getAllCourses();
		Set<Course> studentCourseDetails = studentService
				.getStudentDetailsWithID(Integer.parseInt((sId == null) ? "0" : sId)).getCourses();

		List<String> courseIds = new ArrayList<>();
		List<String> courseNames = new ArrayList<>();

		for (Course course : studentCourseDetails) {
			if (course != null) {
				courseIds.add(course.getcId().toString());
				courseNames.add(course.getcName());
			}
		}
		// validating the User CourseNames which already Registered
		if (CollectionUtils.containsAny(courseIds, selectedCourseList)) {
			addActionError("User is already registered for :" + courseNames);
		}

		int studentCreditsPresent = getTotalCreditsPresent(studentCourseDetails);
		int selectedCourseCount = getSelectedCoursesCreditCount();
		int totalCredits = studentCreditsPresent + selectedCourseCount;

		// validating the User Total Credits limit off 22
		if (studentCreditsPresent != 0 && totalCredits > 22) {
			addActionError(
					"User has:" + studentCreditsPresent + " credits,Limit is 22,Please remove" + (totalCredits - 22));
		}
		if (studentCreditsPresent == 0 && selectedCourseCount > 22) {
			addActionError("Use selected" + selectedCourseCount + " credits,Limit is 22,Please remove"
					+ (selectedCourseCount - 22));
		}

		// validating courses selected on sameday and sametime
		List<String> coursesOnSameDay = getCoursesOnSameDay(studentCourseDetails);
		if (!coursesOnSameDay.isEmpty()) {
			addActionError("Schedule Conflict with Courses:" + coursesOnSameDay);
		}

	}

	private int getSelectedCoursesCreditCount() {
		int selectedCourseCount = 0;
		for (String courseId : selectedCourseList) {
			for (Course course : courseDetails) {
				if (courseId.equalsIgnoreCase(course.getcId().toString())) {
					selectedCourseCount += course.getcCredits();
				}
			}
		}
		return selectedCourseCount;
	}

	private int getTotalCreditsPresent(Set<Course> studentCourseDetails) {
		int totalCredits = 0;
		for (Course course : studentCourseDetails) {
			if (course != null) {
				totalCredits = totalCredits + course.getcCredits();
			}
		}
		return totalCredits;
	}

	private List<String> getCoursesOnSameDay(Set<Course> studentCourseDetails) {

		List<Course> coursList = new ArrayList<>();
		Course cDto;
		for (String courseId : selectedCourseList) {
			for (Course course : courseDetails) {
				if (courseId.equalsIgnoreCase(course.getcId().toString())) {
					cDto = new Course();
					cDto.setcWeekName(course.getcWeekName());
					cDto.setcTime(course.getcTime());
					coursList.add(cDto);
				}
			}
		}
		coursList.addAll(studentCourseDetails);

		Map<String, Integer> map = new HashMap<>();
		List<String> repeatedCourses = new ArrayList<>();

		for (Course course1 : coursList) {
			if (map.containsKey(course1.getcWeekName() + "-" + course1.getcTime())) {
				int value = map.get(course1.getcWeekName() + "-" + course1.getcTime());
				map.put(course1.getcWeekName() + "-" + course1.getcTime(), value + 1);
			} else {
				map.put(course1.getcWeekName() + "-" + course1.getcTime(), 1);
			}

		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				repeatedCourses.add(entry.getKey());
			}
		}
		return repeatedCourses;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public List<Course> getCourseDetails() {
		return courseDetails;
	}

	public List<String> getSelectedCourseList() {
		return selectedCourseList;
	}

	public void setSelectedCourseList(List<String> selectedCourseList) {
		this.selectedCourseList = selectedCourseList;
	}
	/*
	 * private void sendMail(String sId) { List<Course> studentCourseDetails =
	 * studentDao.getStudentCourseDetails(Integer.valueOf(sId)); Student
	 * studentDetailsWithID =
	 * studentDao.getStudentDetailsWithID(Integer.valueOf(sId)); try {
	 * MailUtil.generateAndSendEmail(studentDetailsWithID,
	 * studentCourseDetails); } catch (AddressException e) {
	 * e.printStackTrace(); } catch (MessagingException e) {
	 * e.printStackTrace(); } }
	 */

}
