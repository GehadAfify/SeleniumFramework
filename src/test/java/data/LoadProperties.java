package data;
//class bt2ra el data mn elfile w trbot benha w ben el test cases

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	// load file from folder
	public static Properties userData = loadProperties
	(System.getProperty("user.dir")+"\\src\\main\\java\\propirties\\userdata.properties");
	
	private static Properties loadProperties (String path)
	{
		Properties pro = new Properties();
		//stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("erro occured  "+e.getMessage());
		} catch (IOException e) {
			System.out.println("erro occured  "+e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("erro occured  "+e.getMessage());
		}
		return pro;
	}
}
