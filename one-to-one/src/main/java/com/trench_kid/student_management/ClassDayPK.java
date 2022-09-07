package com.trench_kid.student_management;

import java.io.Serializable;
import java.util.Objects;

public class ClassDayPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private int classId;
	private String daysOfWeek;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classId, daysOfWeek);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassDayPK other = (ClassDayPK) obj;
		return classId == other.classId && Objects.equals(daysOfWeek, other.daysOfWeek);
	}

}
