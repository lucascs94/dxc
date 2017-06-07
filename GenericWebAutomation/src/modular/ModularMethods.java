package modular;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ModularMethods {

	//método para setar as propriedades de inicialização do webdriver
	public static Properties getProperties(String nomeArq){
		Properties props = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/configs/"+nomeArq);
			props.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
	
	//configura a localização do geckodriver
	public static void setGeckodriverLocation(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/configs/geckodriver.exe");
	}
	
	//configurar a localização do chromedriver
	public static void setChromeDriverLocation(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/configs/chromedriver.exe"); 
	}

	//metodo para tirar screenshots da tela durante a execução dos scripts
	public static void tiraScreenshot(WebDriver driver){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY/HH-mm-ss");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destfile = dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scr, new File("C:/GWA/Screenshots/"+destfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}