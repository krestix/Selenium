package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class FirstTestClass {
	
	static WebDriver driver = null;
	

	public static void main(String[] args) throws InterruptedException{

//memory location & driver location
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		//launch the browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// implicitwait - different loading times of web elements, so instead of throwing an error immediately we will wait for 15 sec. 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//open the web app
		driver.navigate().to("https://amazon.in");
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.in"))
			System.out.println("Title matches");
		else
			System.out.println(title); 
		
		//locate a web element
		String tagname = " ";
		tagname = driver.findElement(By.cssSelector("#nav-link-shopall > span.nav-line-1")).getText();
		System.out.println(tagname);
		
		WebElement category = driver.findElement(By.cssSelector("#nav-link-shopall > span.nav-line-2 > span"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		Thread.sleep(1000); //pervent too quick process

		
		WebElement books = driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-template.nav-flyout-content.nav-tpl-itemList > span:nth-child(16) > span.nav-text"));
		action.moveToElement(books);
		action.click();
		action.perform();
		Thread.sleep(50);
		
		WebElement myElement = driver.findElement(By.id("twotabsearchtextbox"));
		myElement.sendKeys("John Grisham");
		Thread.sleep(50);
		
		driver.findElement(By.className("nav-input")).click();
		Thread.sleep(1000);
		
		//Select the book
		driver.findElement(By.partialLinkText("Firm")).click();
		Thread.sleep(1000);
		
		
		//shift the tab control
		java.util.Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle();
		handles.remove(winHandle1);
		
		String winHandle = handles.iterator().next();
		String winHandle2 = " ";
		
		if(winHandle != winHandle1)
		{
			winHandle2 = winHandle;
			driver.switchTo().window(winHandle2);
			System.out.println(winHandle2);
		}
		
		Thread.sleep(1000);
			
		
	    driver.findElement(By.cssSelector("#add-to-cart-button")).click();
	    Thread.sleep(3000);
	    
	    //scroll down until (end\web element etc.)
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    Thread.sleep(1000);
	    
	    driver.close();
	    driver.quit();
	}

}
