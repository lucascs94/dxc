package Mariana;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;



@RunWith(Parameterized.class)
public class ParametrizacaoJUnit {

	private String agencia;
	private String conta;
	private String faixaIdade;
	
	private WebDriver driver;
	
	@Before
	public void preCondicao() {
		
			Properties prop = modular.ModularMethods.getProperties("configMariana.txt");
			modular.ModularMethods.setChromeDriverLocation();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			
	}
	
	
	@After
	public void posCondicao() {
			//driver.quit();
	}			

	public ParametrizacaoJUnit(String conta, String agencia) {
		this.agencia = agencia;
		this.conta = conta;
		//this.faixaIdade = faixaIdade;
		
	}
	
	@Test
	public void testeParametrizacaoJUnit()
	{
		driver.findElement(By.id("campo_agencia")).sendKeys(agencia);
		driver.findElement(By.id("campo_conta")).sendKeys(conta);
		//new Select(driver.findElement(By.id("linkfirst"))).selectByVisibleText(faixaIdade);
		//driver.findElement(By.id("ancoraConteudo")).click();
		
		
		assertEquals(agencia, driver.findElement(By.id("campo_agencia']")).getText());
		assertEquals(conta, driver.findElement(By.id("campo_conta']")).getText());
		//assertEquals(faixaIdade, driver.findElement(By.cssSelector("span[ng-bind='faixaSelecionada']")).getText());
		
	}
	
	@Parameters(name = "{index}: {0}|{1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"6319", "13530-4"},
			{"1515", "12563-1"}
		});
	}
}
