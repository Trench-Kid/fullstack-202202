package com.trench_kid.student_management;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Entity
public class Employee extends Account {

	private static final long serialVersionUID = 1L;

	@Column(length = 45)
	private String name;
	@Column(length = 12)
	private String phone;
	private String email;
	private Role role;
	
	
	@OneToOne(mappedBy = "employee")
	private Class c;

	public enum Role {
		ADMIN, TEACHER
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
