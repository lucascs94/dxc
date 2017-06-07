package Mariana;

import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItauBank {

	private static WebDriver driver;

	@Before
		public void setUp () {
		modular.ModularMethods.setChromeDriverLocation();
		driver =  new ChromeDriver();
		driver.get("http://www.itau.com.br/");
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void acessarConta(){
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("campo_agencia")));
	WebElement ag = driver.findElement(By.id("campo_agencia"));
	ag.sendKeys("6319");
	//ag.submit();
	
	
		
}
	
	@AfterClass
	public static void DriverTearDown(){
		//driver.quit();
	}
}




