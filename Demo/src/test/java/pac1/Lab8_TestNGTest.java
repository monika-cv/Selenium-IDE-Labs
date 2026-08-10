package pac1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_TestNGTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Reporter.log("Browser launched and maximized.", true);
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        driver.get("https://tutorialsninja.com/demo/");
        Reporter.log("Navigated to OpenCart demo homepage.", true);

        String title = driver.getTitle();
        Assert.assertEquals(title, "Your Store", "Title verification failed!");
        Reporter.log("Home page title verified successfully: " + title, true);
    }

    @Test(priority = 2)
    public void verifyRegisterPage() {
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        Reporter.log("Navigated to Register page.", true);

        String heading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(heading, "Register Account", "Register page heading mismatch!");
        Reporter.log("Register page heading verified successfully: " + heading, true);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            Reporter.log("Browser closed successfully.", true);
        }
    }
}
