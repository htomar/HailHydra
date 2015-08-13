package org.hydra.mongodb.model;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Holidays {
	@Id
	private String id; 
	private List<Calendar> hdates;
	private String hDescriptions;
	public List<Calendar> getHdates() {
		return hdates;
	}
	public void setHdates(List<Calendar> hdates) {
		this.hdates = hdates;
	}
	public String gethDescriptions() {
		return hDescriptions;
	}
	public void sethDescriptions(String hDescriptions) {
		this.hDescriptions = hDescriptions;
	}
	
}
