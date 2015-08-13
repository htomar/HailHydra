package org.hydra.mongodb.model;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Releases {
	@Id
	private String id; 
	private List<Calendar> rdates;
	private String rDescriptions;
	public Releases(){};
	public List<Calendar> getRdates() {
		return rdates;
	}
	public void setRdates(List<Calendar> rdates) {
		this.rdates = rdates;
	}
	public String getrDescriptions() {
		return rDescriptions;
	}
	public void setrDescriptions(String rDescriptions) {
		this.rDescriptions = rDescriptions;
	}
	
	
}
