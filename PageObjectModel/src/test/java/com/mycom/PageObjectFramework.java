package com.mycom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PageObjectFramework {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\chamarthi.anusha\\Desktop\\SeleniumWorkspace\\SeleniumFrameworks\\config.properties");
		
		prop.load(ip);
		
		String url=prop.getProperty("URL");
		
		System.out.println(url);
		
		String browser=prop.getProperty("browserName");
		
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
			
		}else if(browser.equals("Firefox")) {
			 driver=new FirefoxDriver();
		}
		
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.id(prop.getProperty("firstname_id"))).sendKeys(prop.getProperty("firstName"));
		
		driver.findElement(By.id(prop.getProperty("lastname_id"))).sendKeys(prop.getProperty("lastName"));
		
		driver.findElement(By.id(prop.getProperty("streetaddress_id"))).sendKeys(prop.getProperty("streetAddress"));
		
		driver.findElement(By.id(prop.getProperty("city_id"))).sendKeys(prop.getProperty("city"));
		
		Select s=new Select(driver.findElement(By.id(prop.getProperty("state_id"))));
		s.selectByVisibleText(prop.getProperty("state"));
		
		
		
		driver.findElement(By.id(prop.getProperty("zip_id"))).sendKeys(prop.getProperty("zip"));
		
		driver.findElement(By.xpath(prop.getProperty("phonenumber_xpath"))).sendKeys(prop.getProperty("primaryPhoneNo1"));
		
		driver.findElement(By.xpath(prop.getProperty("phonenumber1_xpath"))).sendKeys(prop.getProperty("primaryPhoneNo2"));
		
		driver.findElement(By.xpath(prop.getProperty("phonenumber2_xpath"))).sendKeys(prop.getProperty("primaryPhoneNo3"));
		
		driver.findElement(By.xpath(prop.getProperty("phonenumber3_xpath"))).sendKeys(prop.getProperty("extensionPhoneNo"));
		
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("emailAddress"));
		
		driver.findElement(By.xpath(prop.getProperty("retypeemail_xpath"))).sendKeys(prop.getProperty("reenterEmail"));
		
		driver.findElement(By.xpath(prop.getProperty("userid_xpath"))).sendKeys(prop.getProperty("userId"));
		
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath(prop.getProperty("reenter_password_xpath"))).sendKeys(prop.getProperty("reenterPassword"));
		
		
		Select s1=new Select(driver.findElement(By.xpath(prop.getProperty("secretquestion_xpath"))));
		s1.selectByVisibleText(prop.getProperty("secretQuestion"));
		
		driver.findElement(By.xpath(prop.getProperty("secretanswer_xpath"))).sendKeys(prop.getProperty("secretAnswer"));
		
		Select month=new Select(driver.findElement(By.xpath(prop.getProperty("birthdate2_xpath"))));
		month.selectByVisibleText(prop.getProperty("month"));
		
		
		Select day=new Select(driver.findElement(By.xpath(prop.getProperty("birthdate1_xpath"))));
		day.selectByValue(prop.getProperty("day"));
		
		
		Select year=new Select(driver.findElement(By.xpath(prop.getProperty("birthdate3_xpath"))));
		year.selectByVisibleText(prop.getProperty("year"));
		
		
		driver.findElement(By.xpath(prop.getProperty("agree_box_xpath"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("continue_btn_xpath"))).click();
		
		System.out.println("Succesfully registered");
		
		driver.quit();
	}

}

