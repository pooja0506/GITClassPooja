package org.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 public static WebDriver driver;
	 // 1.
	public static void chromeBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}
	// 2.
	public static void LaunchUrl(String url) {

		driver.get(url);
	}
	// 3.
	public static void maxiWindow() {

		driver.manage().window().maximize();

	}
	// 4.
	public static void pageTitle() {
	
		String titleName = driver.getTitle();
		System.out.println("Page Title"+titleName);

	}
	// 5.
	public static void getUrl() {
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}
	// 6.
	public static void sendValue(WebElement element, String value) {
		
		element.sendKeys(value);
		
	}
	// 7.
	public static void text(WebElement element, String name) {
		
		String text = element.getText();
		System.out.println(text);

	}
	// 8.
	public static void buttonClk(WebElement element) {
		
		element.click();

	}
	// 9.		
	public static void rightClick() {
		

	}

}



