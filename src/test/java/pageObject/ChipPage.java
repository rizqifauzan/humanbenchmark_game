package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utitlities.BaseClass;

public class ChipPage extends BaseClass{
	
	public ChipPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath = "//button[.='Start Test']")
	private WebElement startTestButton;

	@FindBy(xpath = "//div[@class='desktop-only']/div/div/div/div")
	private List<WebElement> numbers;
	
	@FindBy(xpath = "//div[.='NUMBERS']//following-sibling::h1")
	private WebElement nextLevel;
	
	@FindBy(xpath = "//button[.='Continue']")
	private WebElement continueButton;
	
	public void clickStart() {
		click(startTestButton);
	}
	
	public int getTotalNumber() {
		return numbers.size();
	}
	
	public String getNumber(int index) {
		return numbers.get(index).getText();
	}
	
	public void clickNumber(int index) {
		click(numbers.get(index));
	}
	
	public String getNextLevel() {
		return nextLevel.getText();
	}
	
	public void clickContinue() {
		click(continueButton);
	}
	
}
