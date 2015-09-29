package org.hydra.web.rest.response.json;

import org.hydra.tasker.db.beans.Task;

public class TaskJson {
	protected String id;
	protected String title;
	protected String desc;
	protected boolean fire;
	protected boolean important;
	private String progress;
	private String subTasks;

	public TaskJson(Task task) {
		this.id = task.getId().toHexString();
		this.title = task.getTitle();
		this.desc = task.getDesc();
		this.fire = task.isFire();
		this.important = task.isImportant();
		this.progress = task.getProgress();
		this.subTasks = "";
		if (null != task.getSubTasks() && !task.getSubTasks().isEmpty()) {
			this.subTasks = "/tasker/getSubTasks?taskId=" + id;
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the fire
	 */
	public boolean isFire() {
		return fire;
	}

	/**
	 * @return the important
	 */
	public boolean isImportant() {
		return important;
	}

	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * @return the subTasks
	 */
	public String getSubTasks() {
		return subTasks;
	}
}
