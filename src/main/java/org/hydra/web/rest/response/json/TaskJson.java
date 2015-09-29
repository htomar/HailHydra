package org.hydra.web.rest.response.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskJson {
	public class Task {
		private String title;
		private String desc;
		private boolean fire;
		private boolean important;
		private String progress;
		private String subTasks;

		public Task(org.hydra.tasker.db.beans.Task task) {
			this.title = task.getTitle();
			this.desc = task.getDesc();
			this.fire = task.isFire();
			this.important = task.isImportant();
			this.progress = task.getProgress();
			this.subTasks = "";
			if (null != task.getSubTasks() && !task.getSubTasks().isEmpty()) {
				this.subTasks = "/tasker/getSubTasks?taskId="
						+ task.getId().toHexString();
			}
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

	private Map<String, Task> tasks;

	public TaskJson() {
		tasks = new HashMap<String, TaskJson.Task>();
	}

	public void addTask(org.hydra.tasker.db.beans.Task task) {
		if (null != task) {
			tasks.put(task.getId().toHexString(), new Task(task));
		}
	}

	public void addTasks(List<org.hydra.tasker.db.beans.Task> activeTasks) {
		if (null != activeTasks && !activeTasks.isEmpty()) {
			for (org.hydra.tasker.db.beans.Task task : activeTasks) {
				addTask(task);
			}
		}
	}

	/**
	 * @return the tasks
	 */
	public Map<String, Task> getTasks() {
		return tasks;
	}
}
