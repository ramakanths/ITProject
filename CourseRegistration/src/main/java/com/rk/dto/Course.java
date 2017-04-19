package com.rk.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue
	@Column(name = "CID")
	private Integer cId;

	@Column(name = "CNAME")
	private String cName;

	@Column(name = "CWEEKNAME")
	private String cWeekName;

	@Column(name = "CTIME")
	private String cTime;

	@Column(name = "CCREDITS")
	private Integer cCredits;

	@ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> students = new HashSet<Student>();

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course(Integer cId, String cName, String cWeekName, String cTime, Integer cCredits, Set<Student> students) {
		this.cId = cId;
		this.cName = cName;
		this.cWeekName = cWeekName;
		this.cTime = cTime;
		this.cCredits = cCredits;
		this.students = students;
	}

	public Course() {
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcWeekName() {
		return cWeekName;
	}

	public void setcWeekName(String cWeekName) {
		this.cWeekName = cWeekName;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public Integer getcCredits() {
		return cCredits;
	}

	public void setcCredits(Integer cCredits) {
		this.cCredits = cCredits;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cWeekName=" + cWeekName + ", cTime=" + cTime
				+ ", cCredits=" + cCredits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cCredits == null) ? 0 : cCredits.hashCode());
		result = prime * result + ((cId == null) ? 0 : cId.hashCode());
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + ((cTime == null) ? 0 : cTime.hashCode());
		result = prime * result + ((cWeekName == null) ? 0 : cWeekName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (cCredits == null) {
			if (other.cCredits != null)
				return false;
		} else if (!cCredits.equals(other.cCredits))
			return false;
		if (cId == null) {
			if (other.cId != null)
				return false;
		} else if (!cId.equals(other.cId))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (cTime == null) {
			if (other.cTime != null)
				return false;
		} else if (!cTime.equals(other.cTime))
			return false;
		if (cWeekName == null) {
			if (other.cWeekName != null)
				return false;
		} else if (!cWeekName.equals(other.cWeekName))
			return false;
		return true;
	}

}
