package test;

//
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.TreeStructure;

public class Login {
	
	WebDriver driver;
	LoginPage FPILogin;
	TreeStructure LeftPane;
	WebElement policy;
	WebElement logOut;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\apps\\Sheetal\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.coaction.com/demo/");
	}
	
	@Test
	public void LogintoMC() throws Exception {
		FPILogin = new LoginPage(driver);
		LeftPane = new TreeStructure(driver);
		FPILogin.loginUser("fpiadmin", "admin123");
		Date startTime = new Date();
		System.out.println(startTime.toGMTString());
		WebDriverWait wait = new WebDriverWait(driver, 180);
		waitForPageLoaded();
		wait.until(ExpectedConditions.elementToBeClickable(LeftPane.getPolicyTreeNode())).click();
		Date endTime = new Date();
		System.out.println(endTime.toGMTString());

	}

	private void waitForPageLoaded() {

		 @SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 			.withTimeout(3,TimeUnit.MINUTES)
		 			.pollingEvery(10,TimeUnit.SECONDS)
		 			.ignoring(NoSuchElementException.class);
		 
		 wait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver){
				 return driver.findElement(By.xpath("//*[@id='gwt-debug-11.1011.My Cases.myCasesGridSection.myCasesGridPanel.myCasesGrid']"));
			 }
		});
				 
				
		
	}
	
	
    

}
