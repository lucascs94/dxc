package lucasScripts;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lucasObjects.Auxiliar;
import lucasObjects.BuscaCepPage;

//@RunWith(Parameterized.class)
public class BuscaCepScript {
	private String cep;
	private static Properties prop;
	private static WebDriver driver;

//	public BuscaCepScript(String cep){
//		this.cep = cep;
//	}

	@BeforeClass
	public static void DriverSetUp(){
		prop = modular.ModularMethods.getProperties("configLucas.txt");
		modular.ModularMethods.setGeckodriverLocation();
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();	
	}

	@Before
	public void TestSetUp(){
	}

	@After
	public void TestTearDown(){

	}

	@AfterClass
	public static void DriverTearDown(){
		driver.quit();
	}

//	@Parameters
//	public static Collection<Object[]> cep() {
//		return Arrays.asList(new Object[][] {{"91520210"}, {"96270000"}, {"90650003"}});
//	}	

	@Test
	public void screenshotTest(){
		Auxiliar aux = new Auxiliar(driver);
		BuscaCepPage home = new BuscaCepPage(driver);
		home.acessar(prop.getProperty("url"));
		aux.esperaFicarVisivelID("cep");
		aux.tiraScreenshot("BuscaCepScript","screenshotTest");
		home.buscarEnderecoPorCep("91520210");
		aux.esperaFicarVisivelXpath("//table[@class='tmptabela']");
		aux.tiraScreenshot("BuscaCepScript","screenshotTest");
	}
}
