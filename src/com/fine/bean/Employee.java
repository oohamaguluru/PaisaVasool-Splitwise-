//@author pavithra
package com.fine.bean;

public class Employee {
	private int oID;
	private String name;
	private double fine;
	private int timeslate;

	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public int getTimeslate() {
		return timeslate;
	}

	public void setTimeslate(int timeslate) {
		this.timeslate = timeslate;
	}

	@Override
	public String toString() {
		return "Employee [oID=" + oID + ", name=" + name + ", fine=" + fine + ", timeslate=" + timeslate + "]";
	}

}
