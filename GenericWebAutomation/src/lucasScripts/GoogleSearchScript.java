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
import lucasObjects.GoogleSearchPage;

@RunWith(Parameterized.class)
public class GoogleSearchScript {

	private String searchContent;
	private static WebDriver driver;
	private static Auxiliar aux;

	public GoogleSearchScript(String searchContent){
		this.searchContent = searchContent;
	}

	@BeforeClass
	public static void DriverSetUp(){
		driver =  new FirefoxDriver();
		aux = new Auxiliar(driver, "config.properties");
		aux.setGeckodriverLocation();
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

	@Parameters
	public static Collection<Object[]> searchContent() {
		return Arrays.asList(new Object[][] {{"como automatizar testes com selenium"}, {"como automatizar testes com testng"}});
	}	

	@Test
	public void screenshotTest(){
		GoogleSearchPage home = new GoogleSearchPage(driver);
		home.acessa(aux.getProperty("url"));
		aux.esperaFicarVisivelID("lst-ib");
		aux.tiraScreenshot("GoogleSearchScript", "screenshotTest");
		home.pesquisa(searchContent);
		aux.esperaFicarVisivelClass("hdtb-mitem");
		aux.tiraScreenshot("GoogleSearchScript", "screenshotTest");
	}
}
