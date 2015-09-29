package org.hydra.web.rest.response.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hydra.tasker.db.beans.Task;

public class MyTasksJson {
	private HashMap<String, List<TaskJson>> tasks;

	public MyTasksJson() {
		tasks = new HashMap<String, List<TaskJson>>();
	}

	public void setActiveTasks(List<Task> taskList) {
		if (null != taskList) {
			List<TaskJson> activeTasks = new ArrayList<TaskJson>();
			for (Task task : taskList) {
				activeTasks.add(new TaskJson(task));
			}
			tasks.put("activeTasks", activeTasks);
		}
	}

	/**
	 * @return the tasks
	 */
	public HashMap<String, List<TaskJson>> getTasks() {
		return tasks;
	}
}
