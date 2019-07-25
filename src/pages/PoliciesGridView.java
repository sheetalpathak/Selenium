package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.BasePage;

public class PoliciesGridView extends BasePage {
	
	
	@FindBy(css="table[id='gwt-debug-11.1011.All Policies.allPoliciesGridSection.allPoliciesGridPanel.allPoliciesGrid']")
	WebElement searchPolicyGrid;
	
	public WebElement getSearchPolicyGrid() {
		return searchPolicyGrid;
	}

	@FindBy(xpath="//td[@id='gwt-debug-11.1011.All Policies.allPoliciesGridSection.allPoliciesGridPanel.allPoliciesGrid.gridfunctions-1']/img")
	WebElement searchAction;
	
	public WebElement getSearchAction() {
		return searchAction;
	}

	private WebDriver driver;
	
	public PoliciesGridView(WebDriver driver) {
		super(driver);
	}
	

}
