package assignment;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BeforeTestStart extends Assessment_Jombay {

	@Before
	public void beforeTest() throws IOException {
		initialize();
	}

	@Test
	public void Assessment_Jombay() throws InterruptedException {
		// selenium code
		driver.get(CONFIG.getProperty("testSiteName"));
		// login

	}

}
