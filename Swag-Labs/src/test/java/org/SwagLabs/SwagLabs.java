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
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ProductPage
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]")).click();
		
		driver.findElement(By.xpath("//*[@data-icon='shopping-cart']")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='subheader']")).getText();
		System.out.println("Application move this Page -> "+text2);
		
		//YouCart
		driver.findElement(By.xpath("(//button[text()='REMOVE'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
		
		String text3 = driver.findElement(By.xpath("//div[@class='subheader']")).getText();
		System.out.println("Application move to this Page -> "+text3);
		
		
		
		
				
		
	
	}

}
