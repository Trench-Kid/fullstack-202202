package com.trench_kid.student_management;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;

@Embeddable
@Entity
@Inheritance(strategy = JOINED)
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "user_name", length = 45)
	private String userName;
	private String password;
	private int activated;
	@Column(name = "register_at")
	private LocalDate registerAt;
	@Column(name = "retire_at")
	private LocalDate retireAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public LocalDate getRegisterAt() {
		return registerAt;
	}

	public void setRegisterAt(LocalDate registerAt) {
		this.registerAt = registerAt;
	}

	public LocalDate getRetireAt() {
		return retireAt;
	}

	public void setRetireAt(LocalDate retireAt) {
		this.retireAt = retireAt;
	}

}
