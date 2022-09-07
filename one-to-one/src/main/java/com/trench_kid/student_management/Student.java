package com.trench_kid.student_management;

import javax.persistence.Entity;

import java.util.Objects;

import javax.persistence.Column;

@Entity
public class Student extends Account {

	private static final long serialVersionUID = 1L;
	@Column(length = 45)
	private String name;
	@Column(length = 45)
	private String phone;
	@Column(length = 45)
	private String gmail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gmail, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(gmail, other.gmail) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

}
