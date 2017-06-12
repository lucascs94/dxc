package lucas;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

//@RunWith(Parameterized.class)
public class GoogleSearchTests {

	//private String searchContent;
	private Properties prop;
	private WebDriver driver;

	@BeforeClass
	public void DriverSetUp(){
		prop = modular.ModularMethods.getProperties("config.properties");
		modular.ModularMethods.setGeckodriverLocation();
		driver =  new FirefoxDriver();
		//driver.get(prop.getProperty("url"));
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

	//	public GoogleSearchTests(String searchContent){
	//		this.searchContent = searchContent;
	//	}

	//	@Parameters
	//	public static Collection<Object[]> data() {
	//		return Arrays.asList(new Object[][] {
	//			{"Jose"},
	//			{"Maria"},
	//			{"João"},
	//			{"Carla"}
	//		});
	//	}


	@DataProvider(name = "SearchContent")
	public static Object[][] searchContent() {
		return new Object[][] {{"joão"}, {"maria"}};
	}	

	@Test(dataProvider = "SearchContent")
	public void screenshotTest(String searchContent){
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//tira screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));
		modular.ModularMethods.tiraScreenshot(driver);

		//executa a pesquisa usando dados parâmetrizados 
		WebElement we = driver.findElement(By.id("lst-ib"));
		we.sendKeys(searchContent);
		we.submit();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//tira screenshot
		wait.until(ExpectedConditions.elementToBeClickable(By.className("hdtb-mitem")));
		modular.ModularMethods.tiraScreenshot(driver);

		we.clear();
	}
}
