package pac1;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC006_ParallelTest {
  @Test
  public void test1() throws InterruptedException {
	  System.out.println("test1:"+Thread.currentThread().getId());
	  WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		Thread.sleep(5000);
  }
  
  @Test
  public void test12() throws InterruptedException {
	  System.out.println("test2:"+Thread.currentThread().getId());
	  WebDriverManager.edgedriver().setup();
		
	  WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	  
  }
  
  @Test
  public void test3() throws InterruptedException {
	  System.out.println("test3:"+Thread.currentThread().getId());
	  WebDriverManager.edgedriver().setup();
		
	  WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.yahoo.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	  
  }
  
  
  @Test
  public void test4() throws InterruptedException {
	  System.out.println("test4:"+Thread.currentThread().getId());
	  WebDriverManager.firefoxdriver().setup();
		
	  WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.rediffmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
  }
}
