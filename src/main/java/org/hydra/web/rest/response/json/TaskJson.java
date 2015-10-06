package org.hydra.web.rest.response.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hydra.tasker.db.beans.BaseTask;
import org.springframework.beans.BeanUtils;

public class TaskJson {
	public class Task extends BaseTask {
		private String subTasks;

		public Task(org.hydra.tasker.db.beans.Task task) {
			this.subTasks = "";
			BeanUtils.copyProperties(task, this);
			if (null != task.getSubTasks() && !task.getSubTasks().isEmpty()) {
				this.subTasks = "/getSubTasks?taskId="
						+ task.getId().toHexString();
			}
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
