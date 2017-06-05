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

	public static Properties getProperties(){
		Properties props = new Properties();
		try {
			FileInputStream file = new FileInputStream("C:/GWA/config.properties");
			props.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}

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
