package lucasObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auxiliar {

	private WebDriver driver;
	private WebDriverWait wait;
	private Properties props;

	public Auxiliar(WebDriver driver, String nomeArq){
		this.driver = driver;
		props = setProperties(nomeArq);
		wait = new WebDriverWait(driver, 30);
	}

	public void esperaFicarVisivelID(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}
	
	public void esperaFicarVisivelName(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
	}

	public void esperaFicarVisivelClass(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
	}
	
	public void esperaFicarVisivelXpath(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}
	
	public void esperaFicarVisivelPartialLinkText(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
	}
	
	public Properties setProperties(String nomeArq){
		props = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/configs/"+nomeArq);
			props.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
	
	public String getProperty(String key){
		return props.getProperty(key);
	}

	public void setGeckodriverLocation(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/configs/geckodriver.exe");
	}

	public void setChromeDriverLocation(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/configs/chromedriver.exe"); 
	}

	public void tiraScreenshot(String className, String testName){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY/HH-mm-ss");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destfile = dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scr, new File("C:/GWA/Screenshots/"+className+"/"+testName+"/"+destfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
