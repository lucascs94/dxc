package modular;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class ModularMethods {
	
	public static Properties getProperties(){
		Properties props = new Properties();
		try {
			FileInputStream file = new FileInputStream("C:/Users/carassai/Desktop/eclipse/config.properties");
			props.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
	
	public static void tiraScreenshot(WebDriver driver){
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY/hh-mm-ssaa");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destfile = dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scr, new File("C:/Users/carassai/Desktop/eclipse/Screenshots/"+destfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
