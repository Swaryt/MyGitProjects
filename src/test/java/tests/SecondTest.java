package tests;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SecondTest {
	
	@Test
	public void IETest()
	{
		System.setProperty("webdriver.ie.driver", "E:\\Automation\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
	}

}
