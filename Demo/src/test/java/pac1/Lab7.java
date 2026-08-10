package pac1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       
        driver.get("https://demo.automationtesting.in/Alerts.html");

        
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert 1 Text: " + alert1.getText());
        alert1.accept();

        
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert 2 Text: " + alert2.getText());
        alert2.accept();

        
        driver.get("https://demo.automationtesting.in/Windows.html");
        String parentWindow = driver.getWindowHandle();

        
        driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();
        driver.findElement(By.xpath("//div[@id='Tabbed']//button")).click();

        
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            String childWindow = it.next();
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println("Child Window Title: " + driver.getTitle());
                driver.close(); 
            }
        }

        
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());

        driver.quit();
        System.out.println("Lab 7 - Alert and Window Handling completed!");
    }
}