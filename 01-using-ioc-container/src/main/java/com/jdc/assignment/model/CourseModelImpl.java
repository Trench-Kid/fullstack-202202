package com.jdc.assignment.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assignment.domain.Course;

public class CourseModelImpl implements CourseModel {

	private static final String SELECT_ALL = "select * from course;";
	private static final String INSERT = "insert into course (name, fees, duration, description) values (?, ?, ?, ?);";
	private static final String SELECT_ONE = "select * from course where id = ?";
	private DataSource dataSource;

	public CourseModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Course> getAll() {
		List<Course> list = new ArrayList<>();
		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(SELECT_ALL)) {

			var result = stmt.executeQuery();

			while (result.next()) {
				var course = new Course();
				course.setId(result.getInt("id"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));

				list.add(course);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Course course) {

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(INSERT);) {

			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getFees());
			stmt.setInt(3, course.getDuration());
			stmt.setString(4, course.getDescription());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Course findById(int courseId) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_ONE);) {
			
			stmt.setInt(1, courseId);
			
			var result = stmt.executeQuery();

			while (result.next()) {
				var course = new Course();
				course.setId(result.getInt("id"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));
				return course;
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
