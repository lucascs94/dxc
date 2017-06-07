package lucas;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class GoogleSearchTests {

	private String searchContent;
	private static Properties prop;
	private static  WebDriver driver;
	
	@BeforeClass
	public static void DriverSetUp(){
		prop = modular.ModularMethods.getProperties("config.properties");
		modular.ModularMethods.setGeckodriverLocation();
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Before
	public void TestSetUp(){
		driver.get(prop.getProperty("url"));
	}

	@After
	public void TestTearDown(){

	}

	@AfterClass
	public static void DriverTearDown(){
		driver.quit();
	}
	
	public GoogleSearchTests(String searchContent){
		this.searchContent = searchContent;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"Jose"},
			{"Maria"},
			{"João"},
			{"Carla"}
		});
	}
	
	@Test
	public void screenshotTest(){
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//tira screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));
		modular.ModularMethods.tiraScreenshot(driver);

		//executa a pesquisa usando dados parâmetrizados 
		WebElement we = driver.findElement(By.id("lst-ib"));
		we.sendKeys(searchContent);
		we.submit();
		
		//tira screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hdtb-mitem")));
		modular.ModularMethods.tiraScreenshot(driver);
		
		we.clear();
	}
}
