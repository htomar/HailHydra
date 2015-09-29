package org.hydra.web.rest.response.json;

import org.hydra.tasker.db.beans.Task;

public class SubTaskJson {
	private String id;
	private String title;
	private String desc;
	private boolean fire;
	private boolean important;
	private boolean play;

	public SubTaskJson(Task task) {
		this.id = task.getId().toHexString();
		this.title = task.getTitle();
		this.desc = task.getDesc();
		this.fire = task.isFire();
		this.important = task.isImportant();
		this.play = task.isPlay();
	}

	/**
	 * @return the play
	 */
	public boolean isPlay() {
		return play;
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
}
