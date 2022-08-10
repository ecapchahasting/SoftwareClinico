package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

public class SurgucalCenterPage extends WebPage{

	public SurgucalCenterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private By EnterSurgical = By.xpath("(//h5[@class='card-title'])[2]");
	private By ValidteSurgicalCenter = By.xpath("(//mat-card-title[@class='subtitulo-seccion mat-card-title'])");
	private By Select = By.xpath("(//div[@class='mat-select-value'])");
	private By room1 = By.xpath("(//span[@class='mat-option-text'])[1]");
	private By SearchResult = By.xpath("(//div[@class='toast-top-right'])");
	private String Result = "(//div[@class='toast-top-right'])";
	private By ButtonRegre = By.xpath("(//button[@class='br-boton-regresar'])");
	
	
	/*##Metodos##*/
	
	public SurgucalCenterPage IgototheSurgicalentergmodule() throws InterruptedException, IOException {
		
		seleniumUtils.click(EnterSurgical);
		System.out.println(seleniumUtils.getText(EnterSurgical)+ " present");
		Thread.sleep(2000);
		seleniumUtils.AssertElementPresent(ValidteSurgicalCenter);
		System.out.println(seleniumUtils.getText(ValidteSurgicalCenter)+ " present");
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new SurgucalCenterPage(driver);
	}
	public SurgucalCenterPage igogoingtolookforaroominthesurgicalcentermodule() throws InterruptedException, IOException {
		
		seleniumUtils.click(Select);
		System.out.println(seleniumUtils.getText(Select));
		Thread.sleep(2000);
		seleniumUtils.AssertElementPresent(room1);
		seleniumUtils.click(room1);
		System.out.println(seleniumUtils.getText(room1));
		seleniumUtils.AssertElementPresent(SearchResult);
		System.out.println(seleniumUtils.getText(SearchResult));
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new SurgucalCenterPage(driver);
	}
	public SurgucalCenterPage verifyMessage(String message) throws Exception {
		String messageResult_xpath = util.replaceText(Result, message);
		if (seleniumUtils.ElementExists(By.xpath(messageResult_xpath))) {
			System.out.println("The message warning exists");
		} else{
			System.out.println("The message warning doesnt exists");
		}
		seleniumUtils.AssertElementPresent(ButtonRegre);
		seleniumUtils.click(ButtonRegre);
		Thread.sleep(5000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new SurgucalCenterPage(driver);
	}
	


}
