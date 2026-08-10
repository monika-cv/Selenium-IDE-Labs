package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		System.out.println("The tile of opencart page is:"+driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
	    System.out.println("Register Title is:"+driver.getTitle());
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String expectedwarning="Warning: You must agree to the Privacy Policy!";
		String actualwarning;
		actualwarning=driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
		
		if(expectedwarning.equals(actualwarning))
		{
			System.out.println("warning message is displayed as expected");
		}
		else
		{
			System.out.println("warning message is not displayed as expected");
		}
	String longText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567"; 
    
    WebElement firstName = driver.findElement(By.id("input-firstname"));
    firstName.sendKeys(longText);
    
    WebElement lastName = driver.findElement(By.id("input-lastname"));
    lastName.sendKeys(longText);
    
    driver.findElement(By.id("input-email")).sendKeys("testuser" + System.currentTimeMillis() + "@gmail.com");
    driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
    
    driver.findElement(By.id("input-password")).sendKeys("Password123");
    driver.findElement(By.id("input-confirm")).sendKeys("Password123");
    
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    
    String expectedNameError = "First Name must be between 1 and 32 characters!";
    String actualNameError = driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
    
    if(expectedNameError.equals(actualNameError))
    {
        System.out.println("first name error message is displayed as expected");
    }
    else
    {
        System.out.println("first name error message is not displayed as expected");
    }
    
    driver.quit();
}
}
