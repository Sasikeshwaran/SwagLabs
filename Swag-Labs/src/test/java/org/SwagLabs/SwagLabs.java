package org.SwagLabs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabs {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//LoginPage
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String text = driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		System.out.println("Application move this page -> "+text);
		
		
		//ProductPage
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]")).click();
		
		driver.findElement(By.xpath("//*[@data-icon='shopping-cart']")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='subheader']")).getText();
		System.out.println("Application move this Page -> "+text2);
		
		
		//YouCartPage
		driver.findElement(By.xpath("(//button[text()='REMOVE'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
		
		String text3 = driver.findElement(By.xpath("//div[@class='subheader']")).getText();
		System.out.println("Application move to this Page -> "+text3);
		
		//InformationPage
		driver.findElement(By.id("first-name")).sendKeys("Abcdefghi");
		driver.findElement(By.id("last-name")).sendKeys("123456");
		driver.findElement(By.id("postal-code")).sendKeys("600081");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		String text4 = driver.findElement(By.xpath("//div[@class='subheader']")).getText();
		System.out.println("Application move to this Page -> "+text4);

		
		//OverViewPage
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		driver.findElement(By.xpath("//button[text()='<- Back']")).click();
		driver.findElement(By.xpath("//a[text()='FINISH']")).click();
		
		String text5 = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		System.out.println("Application successfully move to this page -> "+text5);
		
		
				
		
	
	}

}
