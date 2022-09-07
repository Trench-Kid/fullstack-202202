package com.trench_kid.student_management;

import java.io.Serializable;
import java.util.Objects;

public class RegistrationPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int classId;

	private int studentId;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationPK other = (RegistrationPK) obj;
		return classId == other.classId && studentId == other.studentId;
	}

}
