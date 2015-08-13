package org.hydra.mongodb.model;

import org.springframework.data.annotation.Id;

public class User {
	//id will be used for storing MongoDB _id
    @Id
    private String id;
    private String logonID;
    private String oracleID;
    private String password;
    private String emailID;
    private String Designation;
	public String getLogonID() {
		return logonID;
	}
	public void setLogonID(String logonID) {
		this.logonID = logonID;
	}
	public String getOracleID() {
		return oracleID;
	}
	public void setOracleID(String oracleID) {
		this.oracleID = oracleID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
  
    

}
