package straitstimes.web.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class webautomation {
	
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
	   driver = new ChromeDriver();
		
		
		
		
		driver.get("https://www.straitstimes.com/");
		driver.manage().window().maximize();
		
		
		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	    WebElement login = driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/div[2]/div/ul/li[1]/a"));
		login.click();
				
		
		driver.findElement(By.xpath("//*[@id=\"j_username\"]")).sendKeys("digitaltest2");
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"j_password\"]")).sendKeys("Sphdigital1");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/div[2]/form/button")).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				
		WebElement user=driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/div[2]/div/ul/li[1]/a"));
				
		if (user.getText().equalsIgnoreCase("digitaltest2"))
				
				System.out.println("User is logged in succesfully");
		else 
				System.out.println("login failed: Retry");
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
				
				
				String mainArticleHomePage = driver.findElement(By.xpath("(//span[@class='story-headline']/a)[1]")).getText();
				System.out.println("mainArticleHomePage: "+mainArticleHomePage);
				
				if(isElementPresentCheckUsingJavaScriptExecutor(driver.findElement(By.xpath("(//div[@class='content']//img)[1]"))))
				{
					System.out.println("Main article contains picture/video");
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[@class='story-headline']/a)[1]")));
				}
				else
				{
					System.out.println("Main article does not contain picture/video");
				}
				
				String mainArticleNewPage = driver.findElement(By.xpath("//h1[@class='headline node-title']")).getText();
				System.out.println("mainArticleNewPage: "+mainArticleNewPage);
				if(mainArticleHomePage.equals(mainArticleNewPage))
				{
					System.out.println("Page has successfully navigated to the main article");
				}
				else
				{
					System.out.println("Page could not navigate to the main article");
				}
				
				if(driver.getCurrentUrl().contains("singapore") && isElementPresentCheckUsingJavaScriptExecutor(driver.findElement(By.xpath("//picture[@class='img-responsive']/img"))))
				{
					System.out.println("Main article contains picture/video after navigation");
				}
				else
				{
					System.out.println("Main article does not contain picture/video after navigation");
				}
			}
			
			public static boolean isElementPresentCheckUsingJavaScriptExecutor(WebElement element) {
		        JavascriptExecutor jse=(JavascriptExecutor) driver;
		        try {
		            Object obj = jse.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;",
		                    element);
		            if (obj.toString().contains("true")) {
		                System.out.println("isElementPresentCheckUsingJavaScriptExecutor: SUCCESS");
		                return true;
		            } else {
		                System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
		            }

		        } catch (NoSuchElementException e) {
		            System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
		        }
		        return false;
				
				
				
				
				
				
		
		

	}}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	    
	    

		
		
		
		



