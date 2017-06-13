package lucasObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuscaCepPage {

	private WebDriver driver;

	public BuscaCepPage(WebDriver driver){
		this.driver = driver;
	}

	public BuscaCepPage acessar(String url){
		driver.get(url);
		return this;
	}

	public void buscarEnderecoPorCep(String cep){
		driver.findElement(By.id("cep")).sendKeys(cep);
		driver.findElement(By.xpath("//input[@type='Submit']")).click();
	}
}
