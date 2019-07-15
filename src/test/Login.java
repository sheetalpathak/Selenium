package test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Login {
	
	WebDriver driver;
	LoginPage FPILogin;
	WebElement policy;
	WebElement logOut;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://uat.coaction.com/demo/");
	}
	
	@Test
	public void LogintoMC() throws Exception {
		FPILogin = new LoginPage(driver);
		FPILogin.loginUser("fpiadmin", "admin123");
		Date startTime = new Date();
		System.out.println(startTime.toGMTString());
		WebDriverWait wait = new WebDriverWait(driver, 180);
		/*
		 * logOut = FPILogin.getLogOutButton();
		 * wait.until(ExpectedConditions.elementToBeClickable(logOut));
		 */
		//WebElement grid = driver.findElement(By.id("gwt-debug-11.1011.All Cases.openSupportGridSection.openSupportGridPanel.allCasesGrid.datagrid"));
		//wait.until(ExpectedConditions.visibilityOf(grid));
		
		policy = FPILogin.getPolicyTreeNode();
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", policy);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(60000);
		
		wait.until(ExpectedConditions.visibilityOf(policy)).click();
		Date endTime = new Date();
		System.out.println(endTime.toGMTString());

		policy.click();
		
		
	}

}
