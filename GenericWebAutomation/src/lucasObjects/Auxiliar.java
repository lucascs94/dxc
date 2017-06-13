package lucasObjects;

import org.openqa.selenium.By;
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

	public void esperaFicarVisivelClass(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
	}

	public void tiraScreenshot(){
		modular.ModularMethods.tiraScreenshot(driver);
	}
}
