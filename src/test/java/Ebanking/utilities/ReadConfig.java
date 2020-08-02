package Ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;  ///object for properties class

	public ReadConfig()       // constructor as for base class
	{
		File src = new File("./Configuration/Config.Properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}


	public String getApplicationURL()     // Methods are created & every method should return the value.
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	public String getUsername()     /// Methods are created & every method should return the value.
	{
		String username=pro.getProperty("username");
		return username;
	}

	public String getPassword()     /// Methods are created & every method should return the value.
	{
		String password=pro.getProperty("password");
		return password;
	}

	public String getChromePath()     /// Methods are created & every method should return the value.
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIEPath()     /// Methods are created & every method should return the value.
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath()     /// Methods are created & every method should return the value.
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}



}
