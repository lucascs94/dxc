package lucas;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTests {

	private static WebDriver driver;

	@BeforeClass
	public static void DriverSetUp(){
		System.setProperty("webdriver.gecko.driver", modular.ModularMethods.getProperties().getProperty("geckodriver.path"));
		driver =  new FirefoxDriver();
		driver.get(modular.ModularMethods.getProperties().getProperty("url"));
		driver.manage().window().maximize();
	}

	//	@Before
	//	public void TestSetUp(){
	//		
	//	}

	@Test
	public void testOne(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//tira screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));
		modular.ModularMethods.tiraScreenshot(driver);

		//executa a pesquisa
		WebElement we = driver.findElement(By.id("lst-ib"));
		we.sendKeys("testes automatizados com selenium");
		we.submit();

		//tira screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hdtb-mitem")));
		modular.ModularMethods.tiraScreenshot(driver);
	}

	//	@After
	//	public void TestTearDown(){
	//
	//	}

	@AfterClass
	public static void DriverTearDown(){
		//driver.quit();
	}
}
