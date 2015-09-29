package org.hydra.web.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.hydra.tasker.db.beans.Task;
import org.hydra.tasker.db.repository.TaskRepository;
import org.hydra.web.rest.response.json.MyTasksJson;
import org.hydra.web.rest.response.json.SubTaskJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasker")
public class TaskerController {
	private @Autowired TaskRepository taskRepository;

	public @RequestMapping("/getTasks") MyTasksJson getTasks() {
		List<Task> tasks = taskRepository.findByUserId("sunil");
		MyTasksJson myTasksJson = new MyTasksJson();
		myTasksJson.addActiveTasks(tasks);
		return myTasksJson;
	}

	public @RequestMapping("/getSubTasks") HashMap<String, SubTaskJson> getSubTasks(
			@RequestParam(value = "taskId", required = true) String taskId) {
		Task task = taskRepository.findById(new ObjectId(taskId));
		HashMap<String, SubTaskJson> subTasks = new HashMap<String, SubTaskJson>();
		if (null != task) {
			SubTaskJson subTaskJson = new SubTaskJson();
			subTaskJson.addTasks(task.getSubTasks());
			subTasks.put(taskId, subTaskJson);
		}
		return subTasks;
	}

	public @RequestMapping("/createTask") void createTask() {
		Task task1 = new Task();
		task1.setUserId("sunil");
		task1.setTitle("Validation Proxy Session");
		task1.setDesc("Description of task1");
		task1.setFire(false);
		task1.setImportant(false);
		task1.setProgress("pause");
		Task subTask1 = new Task();
		subTask1.setId(ObjectId.get());
		subTask1.setTitle("Validation Proxy 1");
		subTask1.setDesc("Description of subtask1");
		subTask1.setFire(false);
		subTask1.setImportant(false);
		subTask1.setProgress("pause");
		Task subTask2 = new Task();
		subTask2.setId(ObjectId.get());
		subTask2.setTitle("Validation Proxy 2");
		subTask2.setDesc("Description of subtask2");
		subTask2.setFire(false);
		subTask2.setImportant(false);
		subTask2.setProgress("pause");
		List<Task> subTasks1 = new ArrayList<Task>();
		subTasks1.add(subTask1);
		subTasks1.add(subTask2);
		task1.setSubTasks(subTasks1);
		taskRepository.save(task1);

		Task task2 = new Task();
		task2.setUserId("sunil");
		task2.setTitle("Sitespeed session for team");
		task2.setDesc("Description of task2");
		task2.setFire(true);
		task2.setImportant(true);
		task2.setProgress("pause");
		taskRepository.save(task2);
	}
}
