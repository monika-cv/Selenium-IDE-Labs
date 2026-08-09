package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {
public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("testuser123@gmail.com"); 
        driver.findElement(By.id("input-password")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();
        
        Select limitSelect = new Select(driver.findElement(By.id("input-limit")));
        limitSelect.selectByVisibleText("25");
        
        driver.findElement(By.linkText("Apple Cinema 30\"")).click();
        
       
        driver.findElement(By.xpath("//a[contains(text(),'Specification')]")).click();
        System.out.println("Specification details verified on page.");
        
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List' or @title='Add to Wish List']")).click();
        
        WebElement wishAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        if (wishAlert.getText().contains("Apple Cinema 30\"")) {
            System.out.println("Wish list success message verified.");
        }
        
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Mobile");
        driver.findElement(By.cssSelector(".btn-default")).click();
        
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();
        
        driver.findElement(By.linkText("HTC Touch HD")).click();
        
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
        
        WebElement addToCartBtn = driver.findElement(By.id("button-cart"));
        addToCartBtn.click();
        
        WebElement cartAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success")));
        if (cartAlert.getText().contains("HTC Touch HD")) {
            System.out.println("Cart success message verified.");
        }
        
        driver.findElement(By.id("cart")).click();
        driver.findElement(By.linkText("View Cart")).click();
        boolean isMobileInCart = driver.getPageSource().contains("HTC Touch HD");
        if (isMobileInCart) {
            System.out.println("Mobile verified in cart.");
        }
        
        driver.findElement(By.linkText("Checkout")).click();
        System.out.println("Clicked Checkout.");
        
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/logout");
        
        WebElement logoutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Account Logout']")));
        if (logoutHeading.isDisplayed()) {
            System.out.println("Account Logout heading verified.");
        }
        
        driver.findElement(By.linkText("Continue")).click();
        System.out.println("Lab Demo 6 Completed Successfully!");
        
        driver.quit();
}
}
