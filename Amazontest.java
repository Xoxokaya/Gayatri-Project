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


public class Amazontest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
    {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gayatri Kapila\\Desktop\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        
        driver = new ChromeDriver();
        
        driver.get("https://www.amazon.in/");
        
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Iphone X");
        
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        
        Thread.sleep(5000);
        
        WebElement Product = driver.findElement(By.linkText("(Space Grey, 64 GB) with Earbuds (Open Box)"));
        
        Product.click();
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Product);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(Product));
        
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles)
        {
        	
            driver.switchTo().window(handle);
              
            
        }
        
        WebElement Cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

        Cart.click();
        
        Thread.sleep(10000);
        
        WebDriverWait GotoCart_Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement GotoCart = GotoCart_Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"attach-sidesheet-view-cart-button-announce\"]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", GotoCart);

        Actions actions = new Actions(driver);
        actions.moveToElement(GotoCart).click().perform();
        
        Thread.sleep(20000);
        
        
    }

}
