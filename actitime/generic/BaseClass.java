package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		Reporter.log("openBrowser",true);		
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.quit();
	}	
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}	
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);	
		HomePage h=new HomePage(driver);
		h.setLogout();
	}	
}








