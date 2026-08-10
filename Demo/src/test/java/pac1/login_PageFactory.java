package pac1;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class login_PageFactory {
	//WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit'")
	WebElement button;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement Dashboard1;
	
	//	By username =By.name("username");
	//By password=By.name("password");
	//.By button=By.xpath("//button[@type='submit']");
	//By Dashboard1=By.xpath("//h6[text()='Dashboard']");
	
	public void enterusername(String uname)
	{
		username.sendKeys(uname);
		
	}
	public void enterpassword(String pword)
	{
		password.sendKeys(pword);
		
	}
	
	public void clicklogin()
	{
		button.click();
		
	}
	
	public WebElement dashboard()
	{
		return Dashboard1;
	}
	
	
}
