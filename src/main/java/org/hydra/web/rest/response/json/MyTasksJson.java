package org.hydra.web.rest.response.json;

import java.util.List;

import org.hydra.tasker.db.beans.Task;

public class MyTasksJson {
	private TaskJson myt;
	private TaskJson arch;

	public MyTasksJson() {
		myt = new TaskJson();
		arch = new TaskJson();
	}

	public void addActiveTask(Task task) {
		myt.addTask(task);
	}

	public void addActiveTasks(List<Task> activeTasks) {
		myt.addTasks(activeTasks);
	}

	public void addArchiveTask(Task task) {
		arch.addTask(task);
	}

	public void addArchiveTasks(List<Task> activeTasks) {
		arch.addTasks(activeTasks);
	}

	/**
	 * @return the myt
	 */
	public TaskJson getMyt() {
		return myt;
	}

	/**
	 * @return the arch
	 */
	public TaskJson getArch() {
		return arch;
	}
}
