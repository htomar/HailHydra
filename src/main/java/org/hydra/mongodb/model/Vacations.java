package org.hydra.mongodb.model;


import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Vacations {
	
	@Id
	private String id; 
	private List<Calendar> vdates;
	private Calendar lastUpdatedDate;
	private String appliedBY;
	private String approvedBY;
	private String reason;
	private String comments;
	private String status;
	
	public Vacations(){};
	public String getAppliedBY() {
		return appliedBY;
	}
	public void setAppliedBY(String appliedBY) {
		this.appliedBY = appliedBY;
	}
	public String getApprovedBY() {
		return approvedBY;
	}
	public void setApprovedBY(String approvedBY) {
		this.approvedBY = approvedBY;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Calendar getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public List<Calendar> getVdates() {
		return vdates;
	}
	public void setVdates(List<Calendar> vdates) {
		this.vdates = vdates;
	}

}
