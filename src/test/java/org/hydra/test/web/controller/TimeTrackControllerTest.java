package org.hydra.test.web.controller;

import static org.junit.Assert.assertEquals;

import org.hydra.HailHydraApplication;
import org.hydra.web.controller.TimeTrackController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HailHydraApplication.class)
@ActiveProfiles("test")
public class TimeTrackControllerTest {

	private TimeTrackController timeTrackController;

	@Before
	public void setUp() {
		timeTrackController = new TimeTrackController();

	}

	@Test
	public void testTempPassed() throws Exception {
		String userParam = "testuser";
		String result = timeTrackController.temp(userParam);
		assertEquals(result, "passed");
	}

	@Test
	public void testTempNull() throws Exception {
		String userParam = null;
		String result = timeTrackController.temp(userParam);
		assertEquals(result, "failed");
	}

	@Test
	public void testTempEmpty() throws Exception {
		String userParam = "";
		String result = timeTrackController.temp(userParam);
		assertEquals(result, "failed");
	}
}
