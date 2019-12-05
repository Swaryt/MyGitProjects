package tests;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FirstSeleniumWebDriverScriptTest {
	
	WebDriver driver;
	WebElement ele;
	
	@Test
	public void launchTest()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver.exe");
		ChromeDriver cdriver = new ChromeDriver();
	}
	
	@Test
	public void firefoxTest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Automation\\geckodriver.exe");
		FirefoxDriver fdriver = new FirefoxDriver();
	}
	public void handleDropdown()
	{
		Select select = new Select(ele);
		select.selectByIndex(0);
		select.selectByValue(null);
		select.selectByVisibleText(null);
	}
	
	public void alertsTest()
	{
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().getText();
	}
	
	public void browserWindowPopup()
	{
		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			String child = itr.next();
			if(!child.equalsIgnoreCase(parent))
			{
				driver.switchTo().window(child);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}
	
	public void mouseActions()
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		act.contextClick().build().perform();
		
	}
	
	public void captureScreenshot()
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir");
	}

}
