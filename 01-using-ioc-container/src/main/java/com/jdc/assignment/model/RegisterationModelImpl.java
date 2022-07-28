package com.jdc.assignment.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assignment.domain.Course;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registeration;

public class RegisterationModelImpl implements RegisterationModel {

	private static final String INSERT = "insert into registration (open_class_id,student,phone,email) values(?,?,?,?);";
	private static final String SELECT = "select r.id, r.student, r.phone, r.email, oc.id openClassId, oc.teacher, oc.start_date, c.id courseId, c.name, c.fees, c.duration, c.description from registration r join open_class oc on oc.id = r.open_class_id join course c on c.id = oc.course_id where oc.id = ?";
	private static final String SELECT_ALL = "select r.id, r.student, r.phone, r.email, oc.id openClassId, oc.teacher, oc.start_date, c.id courseId, c.name, c.fees, c.duration, c.description from registration r join open_class oc on oc.id = r.open_class_id join course c on c.id = oc.course_id";
	private DataSource dataSource;

	public RegisterationModelImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Registeration reg) {
		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(INSERT);) {

			stmt.setInt(1, reg.getOpenClass().getId());
			stmt.setString(2, reg.getStudent());
			stmt.setString(3, reg.getPhone());
			stmt.setString(4, reg.getEmail());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Registeration> findByClass(int id) {
		List<Registeration> list = new ArrayList<Registeration>();

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(SELECT)) {

			stmt.setInt(1, id);
			var result = stmt.executeQuery();

			while (result.next()) {
				var reg = new Registeration();
				var oc = new OpenClass();
				var c = new Course();
				
				c.setId(result.getInt("courseId"));
				c.setName(result.getString("name"));
				c.setFees(result.getInt("fees"));
				c.setDuration(result.getInt("duration"));
				c.setDescription(result.getString("description"));
				
				oc.setId(result.getInt("openClassId"));
				oc.setCourse(c);
				oc.setStartDate(result.getDate("start_date").toLocalDate());
				oc.setTeacher(result.getString("teacher"));
				
				reg.setId(result.getInt("id"));
				reg.setOpenClass(oc);
				reg.setStudent(result.getString("student"));
				reg.setEmail(result.getString("email"));
				reg.setPhone(result.getString("phone"));
				
				list.add(reg);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Registeration> getAll() {
		List<Registeration> list = new ArrayList<>();
		
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_ALL);) {
			
			var result = stmt.executeQuery();
			
			while(result.next()) {
				var reg = new Registeration();
				var oc = new OpenClass();
				var c = new Course();
				
				c.setId(result.getInt("courseId"));
				c.setName(result.getString("name"));
				c.setFees(result.getInt("fees"));
				c.setDuration(result.getInt("duration"));
				c.setDescription(result.getString("description"));
				
				oc.setId(result.getInt("openClassId"));
				oc.setCourse(c);
				oc.setStartDate(result.getDate("start_date").toLocalDate());
				oc.setTeacher(result.getString("teacher"));
				
				reg.setId(result.getInt("id"));
				reg.setOpenClass(oc);
				reg.setStudent(result.getString("student"));
				reg.setEmail(result.getString("email"));
				reg.setPhone(result.getString("phone"));
				
				list.add(reg);
			}
			return list;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
