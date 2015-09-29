package org.hydra.web.rest.response.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hydra.tasker.db.beans.Task;

public class SubTaskJson {
	public class SubTask {
		private String title;
		private String desc;
		private boolean fire;
		private boolean important;
		private boolean play;

		public SubTask(Task task) {
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

	private Map<String, SubTask> subTasks;

	public SubTaskJson() {
		subTasks = new HashMap<String, SubTask>();
	}

	public void addTask(Task task) {
		if (null != task) {
			subTasks.put(task.getId().toHexString(), new SubTask(task));
		}
	}

	public void addTasks(List<Task> activeTasks) {
		if (null != activeTasks && !activeTasks.isEmpty()) {
			for (Task task : activeTasks) {
				addTask(task);
			}
		}
	}

	/**
	 * @return the subTasks
	 */
	public Map<String, SubTask> getSubTasks() {
		return subTasks;
	}
}
