package com.rk.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "SID")
	private Integer sId;

	@Column(name = "SNAME")
	private String sName;

	@Column(name = "SEMAIL")
	private String sEmail;

	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "COURSE_REG", joinColumns = { @JoinColumn(name = "SID") }, inverseJoinColumns = {
			@JoinColumn(name = "CID") })
	private Set<Course> courses = new HashSet<Course>();
	
	public void addCourse(Course course){
		this.courses.add(course);
		course.getStudents().add(this);
	}

	public Student() {
	}

	public Student(Integer sId, String sName, String sEmail, Set<Course> courses) {
		this.sId = sId;
		this.sName = sName;
		this.sEmail = sEmail;
		this.courses = courses;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sEmail=" + sEmail + ", courses=" + courses + "]";
	}

}
