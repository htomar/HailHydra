package org.hydra;

import static org.junit.Assert.assertEquals;

import org.hydra.web.controller.TimeTrackController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HailHydraApplication.class)
@WebAppConfiguration
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
		System.out.println("result" + result);
		assertEquals(result, "passed");
	}

	@Test
	public void testTempNull() throws Exception {
		String userParam = null;
		String result = timeTrackController.temp(userParam);
		assertEquals(result, "passed");
	}

	@Test
	public void testTempEmpty() throws Exception {
		String userParam = "";
		String result = timeTrackController.temp(userParam);
		assertEquals(result, "failed");
	}
}
