package com.fine.bean;

public class User {

	private int oID;
	private String password;
	private String name;
	private String imageName;

	public int getoID() {
		return oID;
	}
 
	public void setoID(int oID) {
		this.oID = oID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "User [oID=" + oID + ", password=" + password + ", name=" + name + ", imageName=" + imageName + "]";
	}
	
	

	
}
