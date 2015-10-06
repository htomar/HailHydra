package org.hydra.web.rest.response.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hydra.tasker.db.beans.BaseTask;
import org.hydra.tasker.db.beans.SubTask;
import org.springframework.beans.BeanUtils;

public class SubTaskJson {
	private Map<String, BaseTask> subTasks;

	public SubTaskJson() {
		subTasks = new HashMap<String, BaseTask>();
	}

	public void addSubTask(SubTask subTask) {
		if (null != subTask) {
			BaseTask baseTask = new BaseTask();
			BeanUtils.copyProperties(subTask, baseTask);
			subTasks.put(subTask.getId().toHexString(), baseTask);
		}
	}

	public void addSubTasks(List<SubTask> subTasks) {
		if (null != subTasks && !subTasks.isEmpty()) {
			for (SubTask subTask : subTasks) {
				addSubTask(subTask);
			}
		}
	}

	/**
	 * @return the subTasks
	 */
	public Map<String, BaseTask> getSubTasks() {
		return subTasks;
	}
}
