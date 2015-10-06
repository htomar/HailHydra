package org.hydra.tasker.db.beans;

import org.bson.types.ObjectId;

public class SubTask extends BaseTask {
	private ObjectId id;

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}
}
