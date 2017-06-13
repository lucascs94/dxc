package lucasObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public Auxiliar(WebDriver driver){
		this.driver = driver;
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
