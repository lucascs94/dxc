package lucasScripts;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchsWithTestNG {

	private Properties prop;
	private WebDriver driver;

	@BeforeClass
	public void DriverSetUp(){
		prop = modular.ModularMethods.getProperties("config.properties");
		modular.ModularMethods.setGeckodriverLocation();
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();	
	}

	@BeforeMethod
	public void TestSetUp(){
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void TestTearDown(){

	}

	@AfterClass
	public void DriverTearDown(){
		driver.quit();
	}

	@DataProvider(name = "SearchContent")
	public static Object[][] searchContent() {
		return new Object[][] {{"como automatizar testes com selenium"}, {"como automatizar testes com testng"}};
	}	

	@Test(dataProvider = "SearchContent")
	public void screenshotTest(String searchContent){
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//tira screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));
		modular.ModularMethods.tiraScreenshot(driver);

		//executa a pesquisa usando dados parâmetrizados 
		driver.findElement(By.id("lst-ib")).sendKeys(searchContent);
		driver.findElement(By.name("btnG")).click();

		//tira screenshot
		wait.until(ExpectedConditions.elementToBeClickable(By.className("hdtb-mitem")));
		modular.ModularMethods.tiraScreenshot(driver);
	}
}
