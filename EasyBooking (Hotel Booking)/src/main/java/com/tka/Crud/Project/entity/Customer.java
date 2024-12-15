package com.tka.Crud.Project.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "booking")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	private String name;
	
	@Column(name="noofpeople")
	private int noofpeople;
	private String roomtype;
	private String checkinn;
	private String checkout;

	public Customer() {
		super();
	}

	public Customer(int c_id, String name, int noofpeople, String roomtype, String checkinn, String checkout) {
		super();
		this.c_id = c_id;
		this.name = name;
		this.noofpeople = noofpeople;
		this.roomtype = roomtype;
		this.checkinn = checkinn;
		this.checkout = checkout;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoofpeople() {
		return noofpeople;
	}

	public void setNoofpeople(int noofpeople) {
		this.noofpeople = noofpeople;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getCheckinn() {
		return checkinn;
	}

	public void setCheckinn(String checkinn) {
		this.checkinn = checkinn;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Customer [name - " + name + ", roomtype - " + roomtype + ", checkinn - " + checkinn + ", checkout - "
				+ checkout + "]";
	}

}
