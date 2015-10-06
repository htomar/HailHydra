package org.hydra.web.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.hydra.tasker.db.beans.SubTask;
import org.hydra.tasker.db.beans.Task;
import org.hydra.tasker.db.repository.TaskRepository;
import org.hydra.web.rest.beans.TaskProgress;
import org.hydra.web.rest.response.json.MyTasksJson;
import org.hydra.web.rest.response.json.SubTaskJson;
import org.hydra.web.rest.response.json.TaskJson;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasker")
public class TaskerController {
	Logger logger = Logger.getLogger(TaskerController.class.getName());

	private @Autowired TaskRepository taskRepository;

	public @RequestMapping("/getTasks") MyTasksJson getTasks(HttpSession session) {
		List<Task> tasks = taskRepository.findByUserId("sunil");
		MyTasksJson myTasksJson = new MyTasksJson();
		myTasksJson.addActiveTasks(tasks);
		if (null != session) {
			if (null != session.getAttribute("Mine")) {
				logger.info("Mine is " + session.getAttribute("Mine"));
			} else {
				session.setAttribute("Mine", System.currentTimeMillis());
				logger.info("Mine is " + session.getAttribute("Mine"));
			}
		} else {
			logger.info("No Session :(");
		}
		return myTasksJson;
	}

	public @RequestMapping("/getSubTasks") HashMap<String, SubTaskJson> getSubTasks(
			@RequestParam(value = "taskId", required = true) String taskId) {
		Task task = taskRepository.findById(new ObjectId(taskId));
		HashMap<String, SubTaskJson> subTasks = new HashMap<String, SubTaskJson>();
		if (null != task) {
			SubTaskJson subTaskJson = new SubTaskJson();
			subTaskJson.addSubTasks(task.getSubTasks());
			subTasks.put(taskId, subTaskJson);
		}
		return subTasks;
	}

	public @RequestMapping("/createNewTask") TaskJson createTask() {
		Task task = new Task();
		task.setTitle("New Task");
		task.setDesc("New Task");
		task.setUserId("sunil");
		task.setProgress(TaskProgress.STOP);
		taskRepository.save(task);
		TaskJson taskJson = new TaskJson();
		taskJson.addTask(task);
		return taskJson;
	}

	public @RequestMapping("/createNewSubTask") SubTaskJson createSubTask(
			@RequestParam(value = "taskId", required = true) String taskId) {
		SubTaskJson subTaskJson = new SubTaskJson();
		try {
			Task task = taskRepository.findById(new ObjectId(taskId));

			if (null != task) {
				if (null == task.getSubTasks()) {
					task.setSubTasks(new ArrayList<SubTask>());
				}
				SubTask subTask = new SubTask();
				subTask.setId(ObjectId.get());
				subTask.setTitle("New Sub Task");
				subTask.setDesc("New Sub Task");
				subTask.setProgress(TaskProgress.STOP);
				task.getSubTasks().add(subTask);
				taskRepository.save(task);
				subTaskJson.addSubTask(subTask);
			}
		} catch (IllegalArgumentException argumentException) {
			logger.severe("Incorrect Task Id: " + taskId);
		}
		return subTaskJson;
	}

	public @RequestMapping("/updateTask") TaskJson updateTask(
			@RequestParam(value = "taskId", required = true) String taskId,
			@RequestParam(value = "key", required = true) String key,
			@RequestParam(value = "value", required = true) String value) {
		Task task = taskRepository.findById(new ObjectId(taskId));
		TaskJson taskJson = new TaskJson();
		if (null != task) {
			PropertyValue propertyValue = new PropertyValue(key, value);
			BeanWrapper beanWrapper = new BeanWrapperImpl(task);
			beanWrapper.setPropertyValue(propertyValue);
			System.out.println(task);
			taskRepository.save(task);
			taskJson.addTask(task);
		}
		return taskJson;
	}

	public @RequestMapping("/createDummyTask") void createDummyTask() {
		Task task1 = new Task();
		task1.setUserId("sunil");
		task1.setTitle("Validation Proxy Session");
		task1.setDesc("Description of task1");
		task1.setFire(false);
		task1.setImportant(false);
		task1.setProgress(TaskProgress.PAUSE);
		SubTask subTask1 = new SubTask();
		subTask1.setId(ObjectId.get());
		subTask1.setTitle("Validation Proxy 1");
		subTask1.setDesc("Description of subtask1");
		subTask1.setFire(false);
		subTask1.setImportant(false);
		subTask1.setProgress(TaskProgress.PAUSE);
		SubTask subTask2 = new SubTask();
		subTask2.setId(ObjectId.get());
		subTask2.setTitle("Validation Proxy 2");
		subTask2.setDesc("Description of subtask2");
		subTask2.setFire(false);
		subTask2.setImportant(false);
		subTask2.setProgress(TaskProgress.PAUSE);
		List<SubTask> subTasks1 = new ArrayList<SubTask>();
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
		task2.setProgress(TaskProgress.PAUSE);
		taskRepository.save(task2);
	}
}
