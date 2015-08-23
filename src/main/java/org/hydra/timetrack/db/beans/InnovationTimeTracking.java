package org.hydra.timetrack.db.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inntimetracking")
public class InnovationTimeTracking {
	@Id
	private String id;

	private String email;
	private long week;
	private long effort;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the week
	 */
	public long getWeek() {
		return week;
	}

	/**
	 * @param week
	 *            the week to set
	 */
	public void setWeek(long week) {
		this.week = week;
	}

	/**
	 * @return the effort
	 */
	public long getEffort() {
		return effort;
	}

	/**
	 * @param effort
	 *            the effort to set
	 */
	public void setEffort(long effort) {
		this.effort = effort;
	}
}
