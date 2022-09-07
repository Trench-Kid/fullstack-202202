package com.trench_kid.student_management;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	private String name;
	private int hour;
	private String level;
	@Column(name = "online_fee")
	private int onlineFee;
	@Column(name = "offline_fee")
	private int offlineFee;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getOnlineFee() {
		return onlineFee;
	}
	public void setOnlineFee(int onlineFee) {
		this.onlineFee = onlineFee;
	}
	public int getOfflineFee() {
		return offlineFee;
	}
	public void setOfflineFee(int offlineFee) {
		this.offlineFee = offlineFee;
	}
	
	

}
