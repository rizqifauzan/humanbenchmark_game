package utitlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {
	public static WebDriver webDriver;

	public BaseClass(WebDriver webDriver) {
		BaseClass.webDriver = webDriver;
	}
	
	public void click(WebElement webElement) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webElement.click();
	}
	
}
