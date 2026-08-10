package pac1;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_JUnitTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testOpenCartRegistration() {
        driver.get("https://tutorialsninja.com/demo/");
        
       
        String homeTitle = driver.getTitle();
        Assertions.assertEquals("Your Store", homeTitle, "Home page title does not match!");

       
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();

     
        String heading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assertions.assertEquals("Register Account", heading, "Register page heading mismatch!");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
