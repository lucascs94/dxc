package lucasObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
	private WebDriver driver;
	

	public GoogleSearchPage(WebDriver driver){
		this.driver = driver;
		
	}

	public GoogleSearchPage acessa(String url){
		driver.get(url);
		return this;
	}

	public void pesquisa(String searchContent){
		driver.findElement(By.id("lst-ib")).sendKeys(searchContent);
		driver.findElement(By.name("btnG")).click();
	}
}
