package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TreeStructure {
	
	@FindBy(xpath = "//div[@id='gwt-debug-All Policies-content']//*[text()=' All Policies']")
	WebElement PolicyTreeNode;
	
	@FindBy(xpath = "//*[@id='gwt-debug-11.1011.My Cases.myCasesGridSection.myCasesGridPanel.myCasesGrid")
	WebElement MyCasesView ;

	private WebDriver driver;
	
	public TreeStructure(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getMyCasesView() {
		return MyCasesView;
	}

	public WebElement getPolicyTreeNode() {
		return PolicyTreeNode;
	}
	

}
