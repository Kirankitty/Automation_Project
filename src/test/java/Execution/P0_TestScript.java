package Execution;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestScript.LaunchBrowser;

public class P0_TestScript {
	
	
	@Test
	public void Priority1() throws InterruptedException, IOException {
		LaunchBrowser launch=new LaunchBrowser();
		launch.Browser();
	}

}
