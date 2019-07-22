package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoliciesGridView {
	
	
	@FindBy(xpath="gwt-debug-11.1011.All Policies.allPoliciesGridSection.allPoliciesGridPanel.allPoliciesGrid.accountNo[0]")
	WebElement searchPolicy;

	private WebDriver driver;
	
	public PoliciesGridView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
