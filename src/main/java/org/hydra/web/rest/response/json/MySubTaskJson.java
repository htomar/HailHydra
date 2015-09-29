package org.hydra.web.rest.response.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hydra.tasker.db.beans.Task;

public class MySubTaskJson {
	private HashMap<String, List<SubTaskJson>> subTasks;

	public MySubTaskJson() {
		subTasks = new HashMap<String, List<SubTaskJson>>();
	}

	public void setSubTasks(List<Task> subTaskList) {
		if (null != subTaskList) {
			List<SubTaskJson> subTaskJsons = new ArrayList<SubTaskJson>();
			for (Task task : subTaskList) {
				subTaskJsons.add(new SubTaskJson(task));
			}
			subTasks.put("activeSubTasks", subTaskJsons);
		}
	}

	/**
	 * @return the subTasks
	 */
	public HashMap<String, List<SubTaskJson>> getSubTasks() {
		return subTasks;
	}

}
