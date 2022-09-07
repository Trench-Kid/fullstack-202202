package com.trench_kid.student_management;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Class implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "class_type", length = 45)
	private String classType;
	@Column(name = "start_date")
	private LocalDate startDate;
	private String month;
	@Column(name = "time_from")
	private Time timeFrom;
	@Column(name = "time_to")
	private Time timeTo;
	
	@ManyToOne
	private Course course;
	
	@OneToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Employee employee;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Time getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Time getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classType, course, employee, id, month, startDate, timeFrom, timeTo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class other = (Class) obj;
		return Objects.equals(classType, other.classType) && Objects.equals(course, other.course)
				&& Objects.equals(employee, other.employee) && id == other.id && Objects.equals(month, other.month)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(timeFrom, other.timeFrom)
				&& Objects.equals(timeTo, other.timeTo);
	}
	
}
