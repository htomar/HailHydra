package org.hydra.tasker.db.beans;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class Task extends BaseTask {
	@Id
	private ObjectId id;
	private String userId;
	private List<SubTask> subTasks;

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

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the subTasks
	 */
	public List<SubTask> getSubTasks() {
		return subTasks;
	}

	/**
	 * @param subTasks
	 *            the subTasks to set
	 */
	public void setSubTasks(List<SubTask> subTasks) {
		this.subTasks = subTasks;
	}
}
