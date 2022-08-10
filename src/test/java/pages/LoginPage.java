package pages;


import java.io.IOException;

import javax.swing.Action;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;
import common.Utilities;


public class LoginPage extends WebPage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* ## Web Elements ##*/

	private By inputEmail = By.xpath("(//input[@_ngcontent-c1])[1]");
	private By inputPassword = By.xpath("(//input[@_ngcontent-c1])[2]");
	private By buttonIngresar = By.xpath("(//span[@class='mat-button-wrapper'])[2]");
	private By buttonIpress = By.xpath("(//div[@class='mat-select-value'])");
	private By NovoQ = By.xpath("(//span[@class='mat-option-text'])[5]");

	/* ## Methods ##*/

	public HomePage goToOpenUrl() throws IOException, InterruptedException{
		driver.get(ConfigProp.getUrl());
		driver.manage().window().maximize();
		System.out.println("URL is " + driver.getCurrentUrl());
		Thread.sleep(10000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new HomePage(driver);
	}
		
	public HomePage LoginToTIntegro(String email, String password) throws InterruptedException, IOException {
		seleniumUtils.AssertElementPresent(inputEmail);
		seleniumUtils.sendText(inputEmail,ConfigProp.getByKey(email));
		seleniumUtils.AssertElementPresent(inputPassword);
		seleniumUtils.sendText(inputPassword,ConfigProp.getByKey(password));
		seleniumUtils.click(buttonIngresar);
		seleniumUtils.AssertElementPresent(buttonIpress);
		seleniumUtils.click(buttonIpress);
		seleniumUtils.AssertElementPresent(NovoQ);
		seleniumUtils.click(NovoQ);
		Thread.sleep(8000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new HomePage(driver);
	}
	
}
