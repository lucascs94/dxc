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
	Properties prop2 = modular.ModularMethods.getProperties("massa_dados.txt");
	
	@Before
		public void setUp () {
		Properties prop = modular.ModularMethods.getProperties("configMariana.txt");
		modular.ModularMethods.setChromeDriverLocation();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void acessarConta(){
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("campo_agencia")));
	
		WebElement ag = driver.findElement(By.id("campo_agencia"));
		ag.sendKeys(prop2.getProperty("agencia1"));
		
		WebElement numConta = driver.findElement(By.id("campo_conta")); 
		numConta.sendKeys(prop2.getProperty("conta1"));
		
		WebElement botaoAcessar = driver.findElement(By.className("btnSubmit")); 
		botaoAcessar.click();
			
	
	
}
	
	@AfterClass
	public static void DriverTearDown(){
		//driver.quit();
	}
}




