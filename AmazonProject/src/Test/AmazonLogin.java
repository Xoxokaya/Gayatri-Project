package Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonLogin {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
    {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gayatri Kapila\\Desktop\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        
        driver = new ChromeDriver();
        
        driver.get("https://www.amazon.in/");
        
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        
        Login.click();

        Thread.sleep(2000);

        WebElement emailfield = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
                
        emailfield.sendKeys("gayatrikapila@gmail.com");

        WebElement continue_btn = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
                
        continue_btn.click();

        Thread.sleep(2000);

        WebElement passwordfield = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        passwordfield.sendKeys("Devanshi@1987");
		
        WebElement signinPassword = driver.findElement(By.id("signInSubmit"));
        signinPassword.click();
               
        Thread.sleep(60000);

	}

}
