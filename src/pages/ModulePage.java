package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModulePage {
	
	private WebDriver driver;
	
	public ModulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
