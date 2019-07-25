package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.BasePage;

public class ModulePage extends BasePage  {
	
	private WebDriver driver;
	
	public ModulePage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//div[@title='Support']")
	WebElement supportModule;

	public WebElement getSupportModule() {
		return supportModule;
	}

	public void setSupportModule(WebElement supportModule) {
		this.supportModule = supportModule;
	}

}
