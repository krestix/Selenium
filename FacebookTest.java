package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


/* we works step by step: 
 * 1. Create driver
 * 2. set driver name and location (system.setProperty)
 * 3. we set chrome as web driver that we use (new ChromeDriver)
 * 4. we can create timeout to wait
 * 5. we navigate to the link
 */
public class FacebookTest {

	static WebDriver driver = null;


	public static void main(String[] args) throws InterruptedException {
		//set driver settings		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//navigate to selected site
		driver.navigate().to("https://www.facebook.com/");
		
		//select email inputbox and enter the email
		WebElement Email = getDriverBy("inputtext","class");
		Email.sendKeys("yourMail@gmail.com");
		Thread.sleep(50);

		//select password inputbox and enter the password
		WebElement Password = getDriverBy("#pass", "css");
		Password.sendKeys("yourPassword");
		Thread.sleep(4000);
		
		//push login
		WebElement LogIn = getDriverBy("#u_0_2", "css");
		LogIn.click();
		Thread.sleep(6000);
		
		//click on PostWindow (maybe you want to write smth)
		WebElement Post = getDriverBy("js_7","id");
		Post.click();
		
		//go to arrow
		WebElement userNavigationLabel = getDriverBy("userNavigationLabel","id");
		userNavigationLabel.click();
		
		//push logout
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Log Out")).click();

		//close chrome
		driver.close();

	}
	
	public static WebElement getDriverBy(String name, String type)
	{
		switch (type) {
			case "class":
				return (driver.findElement(By.className(name)));
				
		case "css":
				return (driver.findElement(By.cssSelector(name)));
				
		case "id":
				return (driver.findElement(By.id(name)));								
		}
			
		return null;
	}

}
