package stepDefinitions;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObject.ChipPage;

public class ChipSteps {
	public WebDriver webDriver;

	public ChipSteps() {
		webDriver = Hooks.driver;
	}

	@Given("user on the chip page")
	public void startGame() throws Throwable {
		webDriver.navigate().to("https://humanbenchmark.com/tests/chimp");

		ChipPage chipPage = new ChipPage(webDriver);
		chipPage.clickStart();
	}

	@Then("user play game")
	public void playGame() throws InterruptedException {
		ChipPage chipPage = new ChipPage(webDriver);
		int i = 1;
		System.out.print("Level " + i +" : " + "5 Numbers : ");
		
		long start = System.currentTimeMillis();
		firstGame();
		long end = System.currentTimeMillis();
		
		System.out.println( (end-start) + " milisecond");
		boolean isContinue = true;
		do {
			try {
				i++;
				String num = chipPage.getNextLevel();
				
				System.out.print("Level " + i +" : " + num +" Numbers : ");
				
				start = end;
				Thread.sleep(1000);
				nextLevel();
				
			} catch (Exception e) {
				System.err.println(e);
				isContinue = false;
			}
			end = System.currentTimeMillis();
			System.out.println( (end-start) + " milisecond");
		} while (isContinue);

	}

	public void nextLevel() {
		ChipPage chipPage = new ChipPage(webDriver);
		chipPage.clickContinue();

		int totalNumber = chipPage.getTotalNumber();
		//System.out.println(totalNumber);

		LinkedHashMap<String, Integer> numbers = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < totalNumber; i++) {
			numbers.put(chipPage.getNumber(i), i);
		}

		for (int i = 1; i <= totalNumber; i++) {
			try {
				//System.out.println(i);
				chipPage.clickNumber(numbers.get(String.valueOf(i)));
			} catch(Exception e) {
				break;
			}
			
		}

	}

	public void firstGame() {
		ChipPage chipPage = new ChipPage(webDriver);

		try {
			int totalNumber = chipPage.getTotalNumber();
			for (int i = 1; i <= totalNumber; i++) {
				clickNumber(i);
			}

			System.out.println("Next Level : " + chipPage.getNextLevel() + " Numbers");

		} catch (Exception e) {
		}

	}

	public void clickNumber(int number) {
		webDriver.findElement(By.xpath("//div[@class='desktop-only']/div/div/div/div[.='" + number + "']")).click();
	}

}
