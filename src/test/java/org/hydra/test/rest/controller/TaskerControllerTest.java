package org.hydra.test.rest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.hydra.HailHydraApplication;
import org.hydra.tasker.db.repository.TaskRepository;
import org.hydra.web.rest.beans.TaskProgress;
import org.hydra.web.rest.controller.TaskerController;
import org.hydra.web.rest.response.json.MyTasksJson;
import org.hydra.web.rest.response.json.SubTaskJson;
import org.hydra.web.rest.response.json.TaskJson;
import org.hydra.web.rest.response.json.TaskJson.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HailHydraApplication.class)
@ActiveProfiles("test")
public class TaskerControllerTest {
	private @Autowired TaskRepository taskRepository;
	private @Autowired TaskerController taskerController;
	private HttpSession httpSession;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private String taskId = null;

	@Before
	public void set() {
		taskRepository.deleteAll();
		httpSession = new MockHttpSession();
		TaskJson taskJson = taskerController.createTask();
		Set<Entry<String, Task>> taskKeys = taskJson.getTasks().entrySet();
		for (Entry<String, Task> taskKey : taskKeys) {
			taskId = taskKey.getKey();
		}
		taskerController.createSubTask(taskId);
	}

	@Test
	public void testNotNullCreateTasks() throws Exception {
		TaskJson taskJson = taskerController.createTask();
		Assert.assertNotNull(taskJson.getTasks());
	}

	@Test
	public void testSizeCreateTasks() throws Exception {
		TaskJson taskJson = taskerController.createTask();
		Map<String, Task> taskMap = taskJson.getTasks();
		Assert.assertFalse(taskMap.isEmpty());
	}

	@Test
	public void testGetTasks() throws Exception {
		taskerController.createTask();
		MyTasksJson myTasksJson = taskerController.getTasks(httpSession);
		Assert.assertFalse(myTasksJson.getMyt().getTasks().isEmpty());
	}

	@Test
	public void testInvalidGetSubTasks() throws Exception {
		HashMap<String, SubTaskJson> subTasks = taskerController.getSubTasks("123");
		Assert.assertTrue(subTasks.size() == 0);
	}

	@Test
	public void testNotExistingGetSubTasks() throws Exception {
		HashMap<String, SubTaskJson> subTasks = taskerController.getSubTasks(new ObjectId().toHexString());
		Assert.assertTrue(subTasks.size() == 0);
	}

	@Test
	public void testSuccessGetSubTasks() throws Exception {
		HashMap<String, SubTaskJson> subTasks = taskerController.getSubTasks(taskId);
		Assert.assertTrue(subTasks.size() > 0);
	}

	@Test
	public void testInvalidUpdateTasks() throws Exception {
		TaskJson taskJson = taskerController.updateTask("123", "progress", TaskProgress.START.getProgress());
		Assert.assertTrue(taskJson.getTasks().isEmpty());
	}

	@Test
	public void testNotExistingUpdateTasks() throws Exception {
		TaskJson taskJson = taskerController.updateTask(new ObjectId().toHexString(), "progress",
				TaskProgress.START.getProgress());
		Assert.assertTrue(taskJson.getTasks().isEmpty());
	}

	@Test
	public void testInvalidPropertyUpdateTasks() throws Exception {
		TaskJson taskJson = taskerController.updateTask(taskId, "status", TaskProgress.START.getProgress());
		Assert.assertTrue(taskJson.getTasks().isEmpty());
	}

	@Test
	public void testSuccessUpdateTasks() throws Exception {
		TaskJson taskJson = taskerController.updateTask(taskId, "progress", TaskProgress.START.getProgress());
		Assert.assertFalse(taskJson.getTasks().isEmpty());
	}

	@Test
	public void testInvalidCreateSubTasks() throws Exception {
		SubTaskJson subTaskJson = taskerController.createSubTask("123");
		Assert.assertTrue(subTaskJson.getSubTasks().isEmpty());
	}

	@Test
	public void testNotExistingCreateSubTasks() throws Exception {
		SubTaskJson subTaskJson = taskerController.createSubTask(new ObjectId().toHexString());
		Assert.assertTrue(subTaskJson.getSubTasks().isEmpty());
	}

	@Test
	public void testSuccessCreateSubTasks() throws Exception {
		SubTaskJson subTaskJson = taskerController.createSubTask(taskId);
		Assert.assertFalse(subTaskJson.getSubTasks().isEmpty());
	}
}
