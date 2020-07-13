package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper
{
	//method to take screen screenshot when test cases fail
	public static void captureScreenshot (WebDriver driver , String screenshotname) 
	{
		Path dest = Paths.get("./Screenshots/",screenshotname+".png");
		try {
			
			Files.createDirectory(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while Taking Screenshots"+e.getMessage());
		}
	}
}
