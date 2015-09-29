package org.hydra.test.rest.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hydra.HailHydraApplication;
import org.hydra.timetrack.db.beans.TimeTrackUsers;
import org.hydra.timetrack.db.repository.InnovationTimeTrackingRepository;
import org.hydra.timetrack.db.repository.TimeTrackUsersRepository;
import org.hydra.web.rest.controller.TimeTrackingUserController;
import org.hydra.web.rest.response.json.BaseJsonResponse;
import org.hydra.web.rest.response.json.TimeTrackingUsersJson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HailHydraApplication.class)
public class TimeTrackingUserControllerTest {
	private @Autowired TimeTrackUsersRepository timeTrackUsersRepository;
	private @Autowired TimeTrackingUserController timeTrackingUserController;
	private @Autowired InnovationTimeTrackingRepository trackingRepository;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private List<TimeTrackUsers> users = null;

	@Before
	public void set() {
		timeTrackUsersRepository.deleteAll();
		trackingRepository.deleteAll();
		users = timeTrackingUserController.getUsers();
	}

	@Test
	public void testGetUsersNotNull() throws Exception {
		Assert.assertNotNull("The list should not be null", users);
	}

	@Test
	public void testGetUsersNotEmpty() throws Exception {
		Assert.assertFalse(users.isEmpty());
	}

	@Test
	public void testGetUsersSize() throws Exception {
		Assert.assertTrue(users.size() == 1);
	}

	@Test
	public void testGetUsersSuccess() throws Exception {
		List<TimeTrackUsers> users = timeTrackingUserController.getUsers();
		for (TimeTrackUsers user : users) {
			assertEquals(user.getEmail(), "htomar@sapient.com");
		}
	}

	@Test
	public void testSearchUsersEmpty() throws Exception {
		TimeTrackingUsersJson usersJson = timeTrackingUserController
				.searchUser("");
		assertEquals(BaseJsonResponse.ResponseStatus.OK.getStatus(),
				usersJson.getStatus());
		assertThat(usersJson.getTimeTrackUsers().size(), greaterThan(0));
	}

	@Test
	public void testSearchUsersNull() throws Exception {
		exception.expect(NullPointerException.class);
		timeTrackingUserController.searchUser(null);
	}

	@Test
	public void testSearchUsersNoRecord() throws Exception {
		TimeTrackingUsersJson usersJson = timeTrackingUserController
				.searchUser("unknown");
		assertEquals(BaseJsonResponse.ResponseStatus.OK.getStatus(),
				usersJson.getStatus());
		assertThat(usersJson.getTimeTrackUsers().size(), is(0));
	}

	@Test
	public void testSearchUsersSuccess() throws Exception {
		TimeTrackingUsersJson usersJson = timeTrackingUserController
				.searchUser("htomar");
		assertEquals(BaseJsonResponse.ResponseStatus.OK.getStatus(),
				usersJson.getStatus());
		for (TimeTrackUsers user : usersJson.getTimeTrackUsers()) {
			assertEquals(user.getEmail(), "htomar@sapient.com");
		}
	}

	@Test
	public void testUpdateDetailsNullEmail() throws Exception {
		BaseJsonResponse jsonResponse = timeTrackingUserController
				.updateDetails(null, 34, 75);
		assertEquals(BaseJsonResponse.ResponseStatus.ERROR.getStatus(),
				jsonResponse.getStatus());
		assertEquals(BaseJsonResponse.DEFAULT_ERROR_MSG,
				jsonResponse.getMessage());
	}

	@Test
	public void testUpdateDetailsEmptyEmail() throws Exception {
		BaseJsonResponse jsonResponse = timeTrackingUserController
				.updateDetails("", 34, 75);
		assertEquals(BaseJsonResponse.ResponseStatus.ERROR.getStatus(),
				jsonResponse.getStatus());
		assertEquals(BaseJsonResponse.DEFAULT_ERROR_MSG,
				jsonResponse.getMessage());
	}

	@Test
	public void testUpdateDetailsInvalidEmail() throws Exception {
		BaseJsonResponse jsonResponse = timeTrackingUserController
				.updateDetails("unknownuser@abc.com", 34, 75);
		assertEquals(BaseJsonResponse.ResponseStatus.ERROR.getStatus(),
				jsonResponse.getStatus());
		assertEquals("Invalid email id provided.", jsonResponse.getMessage());
	}

	@Test
	public void testUpdateDetailsFirstUpdate() throws Exception {
		BaseJsonResponse jsonResponse = timeTrackingUserController
				.updateDetails("htomar@sapient.com", 34, 75);
		assertEquals(BaseJsonResponse.ResponseStatus.OK.getStatus(),
				jsonResponse.getStatus());
	}

	@Test
	public void testUpdateDetailsConsequetiveUpdate() throws Exception {
		BaseJsonResponse jsonResponse = timeTrackingUserController
				.updateDetails("htomar@sapient.com", 34, 90);
		assertEquals(BaseJsonResponse.ResponseStatus.OK.getStatus(),
				jsonResponse.getStatus());
	}
}
