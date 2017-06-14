package Mariana;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class) 
public class ItauBank {

	
	private String agencia;
	private String conta;
	
	private static WebDriver driver;
	Properties prop2 = modular.ModularMethods.getProperties("massa_dados.txt");
	
	@Before
	public void preCondicao() {
		
			Properties prop = modular.ModularMethods.getProperties("configMariana.txt");
			modular.ModularMethods.setChromeDriverLocation();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			
	}
	
	public ItauBank(String conta, String agencia) {
		this.agencia = agencia;
		this.conta = conta;
	}
	
	//@Test
	
	
	
	
	@Test
	public void acessarConta()
		{
			driver.findElement(By.id("campo_agencia")).sendKeys(agencia);
			driver.findElement(By.id("campo_conta")).sendKeys(conta);
		
		}
	
	@Parameters(name = "{index}: {0}|{1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"6319", "135304"}
		}); 
	}
	
	@AfterClass
	public static void Final(){
		//driver.quit();
	}
}




