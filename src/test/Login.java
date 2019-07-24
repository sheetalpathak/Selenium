package test;

//
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.BaseDriver;
import pages.LoginPage;
import pages.ModulePage;
import pages.PoliciesGridView;
import pages.TreeStructure;


public class Login extends BaseDriver {
	
	WebDriver driver;
	LoginPage FPILogin;
	TreeStructure LeftPane;
	WebElement policy;
	WebElement logOut;
	ModulePage supportModule;
	
	
	
	@BeforeTest
	public void setup(){
		driver = getDriver();
	}
	
	@Test
	public void LogintoMC() throws Exception {
		FPILogin = new LoginPage(driver);
		supportModule = new ModulePage(driver);
		FPILogin.loginUser("fpiadmin", "admin123");
		WebDriverWait wait = new WebDriverWait(driver, 180);
		/*Date startTime = new Date();
		System.out.println(startTime.toGMTString());*/
		wait.until(ExpectedConditions.visibilityOf(supportModule.getSupportModule()));
		Assert.assertTrue(supportModule.getSupportModule().isDisplayed());
		Reporter.log("Login successfull");
		

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
	
	
    @Test
    public void searchPolicy(){
    	LeftPane = new TreeStructure(driver);
    	PoliciesGridView policy = new PoliciesGridView(driver);
    	WebDriverWait wait = new WebDriverWait(driver, 180);
    	waitForPageLoaded();
		wait.until(ExpectedConditions.elementToBeClickable(LeftPane.getPolicyTreeNode())).click();
		Assert.assertTrue(policy.getSearchPolicyGrid().isDisplayed());
		Reporter.log("Policy grid is visible");
		Date endTime = new Date();
		System.out.println(endTime.toGMTString());
    }

}
