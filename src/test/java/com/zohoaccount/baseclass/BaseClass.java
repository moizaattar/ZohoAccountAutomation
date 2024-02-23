package com.zohoaccount.baseclass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public static void initialization() throws IOException {
		FileReader ip = new FileReader(
				"C:\\Users\\moiza.attar\\eclipse-workspace\\zohoAccount\\src\\test\\java\\com\\zohoaccount\\config\\config.properties");
		prop = new Properties();
		prop.load(ip);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));

	}

}
