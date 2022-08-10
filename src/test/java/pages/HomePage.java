package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import common.ConfigProp;

public class HomePage extends WebPage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* ## Web Elements ##*/
	
	
	private By ValidatedUser = By.xpath("(//span[@class='mat-button-wrapper'])[1]");
	private By AdmisionList1 = By.xpath("(//div[@class='row col-12 principal-cards'])");
	String AdmisionList = "(//div[@class='row col-12 principal-cards'])";
	


	/* ## Methods ##*/


	public HomePage igoValidateUsername() throws IOException {
		seleniumUtils.AssertElementPresent(ValidatedUser);
		System.out.println("Username: " + seleniumUtils.getText(ValidatedUser) + " present");
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new HomePage (driver);
	}

	public HomePage igowillValidateModules() throws IOException, InterruptedException {
		
		int cont = driver.findElements(AdmisionList1).size();
		
		for (int i=0; i<cont; i++) {
			int pos =i+1;
			By ElementsBy = By.xpath(util.replaceText(AdmisionList, Integer.toString(pos)));
			seleniumUtils.moveToElement(ElementsBy);
			System.out.println("Modulos: " +seleniumUtils.getText(ElementsBy));
		}
		
		return new HomePage (driver);
	}





	
}
