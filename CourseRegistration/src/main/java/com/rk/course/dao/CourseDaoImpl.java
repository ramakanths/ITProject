package com.rk.course.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rk.dto.Course;
import com.rk.tables.dao.CommonBaseDao;

@Repository
public class CourseDaoImpl extends CommonBaseDao implements CourseDao {

	@Override
	public List<Course> getCourseDetails() {
		return getAll("from Course");
	}

	@Override
	public Course getCourseWithId(Integer courseId) {
		return getWithId(Course.class, courseId);
	}

	@Override
	public void insertCourse(Course course) {
		saveorUpdate(course);
	}

	@Override
	public void deleteCourse(Course course) {
		delete(course);
	}

	@Autowired
	DataSource dataSource;

	// private JdbcTemplate jdbcTemplateObject;

	/*
	 * @Override public void insertCourseJDBC(CourseDto courseDto) { String SQL
	 * = "insert into course (CNAME,CWEEKNAME,CTIME,CCREDITS) values(?,?,?,?)";
	 * jdbcTemplateObject = new JdbcTemplate(dataSource);
	 * jdbcTemplateObject.update(SQL, courseDto.getcName(),
	 * courseDto.getcWeekName(), courseDto.getcTime(), courseDto.getcCredits());
	 * System.out.println("inserted data");
	 * 
	 * }
	 * 
	 * @Override public List<CourseDto> getCourseDetailsJDBC() { String SQL =
	 * "select * from course"; jdbcTemplateObject = new
	 * JdbcTemplate(dataSource); List<CourseDto> query =
	 * jdbcTemplateObject.query(SQL, new RowMapper<CourseDto>() {
	 * 
	 * @Override public CourseDto mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { CourseDto cd = new CourseDto();
	 * cd.setcId(rs.getInt("CID")); cd.setcName(rs.getString("CNAME"));
	 * cd.setcTime(rs.getString("CTIME"));
	 * cd.setcWeekName(rs.getString("CWEEKNAME"));
	 * cd.setcCredits(rs.getInt("CCREDITS")); return cd; } }); return query; }
	 */

}
