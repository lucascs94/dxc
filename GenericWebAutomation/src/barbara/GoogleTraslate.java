package barbara;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTraslate {
	
	private static WebDriver driver;
	
	@Before
	public void setUp () {
		Properties prop = modular.ModularMethods.getProperties();
		System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriver.path"));
		driver =  new FirefoxDriver();
		driver.get(prop.getProperty("url1"));
		driver.manage().window().maximize();
	
		
	}
	
	
	@Test
	public void translate () {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("text")));
		driver.findElement(By.name("text")).sendKeys("the book is on the table");;
		driver.findElement(By.xpath("//div[2]/input")).click();
		
		
	}
}


