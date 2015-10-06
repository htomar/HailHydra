package org.hydra.tasker.db.beans;

import org.hydra.web.rest.beans.TaskProgress;

public class BaseTask {
	private String title;
	private String desc;
	private boolean fire;
	private boolean important;
	private String progress;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the fire
	 */
	public boolean isFire() {
		return fire;
	}

	/**
	 * @param fire
	 *            the fire to set
	 */
	public void setFire(boolean fire) {
		this.fire = fire;
	}

	/**
	 * @return the important
	 */
	public boolean isImportant() {
		return important;
	}

	/**
	 * @param important
	 *            the important to set
	 */
	public void setImportant(boolean important) {
		this.important = important;
	}

	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * @param taskProgress
	 *            Progress enum
	 */
	public void setProgress(TaskProgress taskProgress) {
		this.progress = taskProgress.getProgress();
	}
}
