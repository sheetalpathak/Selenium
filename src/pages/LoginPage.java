package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy(css="input.UserPassTextBox")
	WebElement userid;
	
	@FindBy(css="input.PassWordTextBox")
	WebElement password;
	
	@FindBy(css="img.loginBtn")
	WebElement loginBtn;
	
	/*@FindBy(xpath = "//div[@id='gwt-debug-All Policies-content']//*[text()=' All Policies']")
	WebElement PolicyTreeNode;*/
	
	@FindBy(css="div.mainPagetLogOutPanel")
	WebElement LogOutButton;
	
	
	public WebElement getLogOutButton() {
		return LogOutButton;
	}

	public WebElement getUserid() {
		return userid;
	}

	public void setUserid(String userID) {
		userid.sendKeys(userID); 
	}

	
	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String userPwd) {
		password.sendKeys(userPwd);
	}

	
	
	public void loginUser(String strUserName,String strPassword){
		//Fill user name
		this.setUserid(strUserName);
		//Fill password
		this.setPassword(strPassword);
		//Click Login button
		this.clickLogin();
				
	}

	private void clickLogin() {
		loginBtn.click();
	}
	 
}
