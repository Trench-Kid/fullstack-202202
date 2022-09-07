package com.trench_kid.student_management;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.JoinColumn;

@Entity
@IdClass(value = RegistrationPK.class)
@SecondaryTable(name = "payments")
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classId;
	@Id
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student studentId;

	private Date registDate;
	private String status;
	private int fees;
	private int discount;
	private int paid;
	
	@Column(name = "paid_date",table = "payments")
	private int paidDate;	
	@Column(name = "to_paid",table = "payments")
	private int toPaid;
	@Column(name = "paid_amount",table = "payments")
	private int paidAmmount;

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

}
