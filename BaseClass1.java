package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	public static WebDriver driver;

	// 1
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2
	public static void winMax() {
		driver.manage().window().maximize();
	}

	// 3
	public static void loadUrl(String url) {
		driver.get(url);
	}

	// 4
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}

	// 5
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	// 6
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// 7.
	public static void btnClick(WebElement ele) {
		ele.click();

	}

	// 8
	public static void closeBrowser() {
		driver.close();

	}

	// 9
	public static void rightClick(WebElement ele, Actions a) {
		a = new Actions(driver);
		a.contextClick(ele).perform();

	}
	//10
	public static void dClick(WebElement ele, Actions a) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();

	}
	//11
	public static String getData(int rowNumber, int cellNumber) throws IOException {
		
		//1
				File f = new File("C:\\PoojaTesting\\Java\\Code\\FrameWorks\\file\\Logindetails.xlsx");
				
				//2
				 FileInputStream fin = new FileInputStream(f); 
				 
				 //3
				Workbook w = new XSSFWorkbook(fin);
				
				//4
				Sheet s = w.getSheet("sheet1");
				
				//5
				Row r = s.getRow(3);
				
				//6
				Cell c = r.getCell(1);
				
				int cellType = c.getCellType();
				 
				String value="";
				if (cellType==1) {
				value = c.getStringCellValue();
					
	}
				else if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd mmmm yyyy");
					value = sim.format(d);
					
					}
				else {
					double d = c.getNumericCellValue();
					//newDataType ref = (newDataType)old variable
					long l = (long)d;
					 value = String.valueOf(l);
					}
				return value;
}
}