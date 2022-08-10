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

public class NursingPage extends WebPage{

	public NursingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private By EnterNursing = By.xpath("(//h5[@class='card-title'])[3]");
	private By Search = By.xpath("(//span[@class='titulo-form'])");
	private By Area = By.xpath("(//div[@class='mat-select-value'])[1]");
	private By SurgicalCenter = By.xpath("(//span[@class='mat-option-text'])[2]");
	private By Service = By.xpath("(//div[@class='mat-select-value'])[2]");
	private By RoomUCI = By.xpath("(//span[@class='mat-option-text'])[2]");
	private By TipoDocumento = By.xpath("(//div[@class='mat-select-value'])[3]");
	private By DNI = By.xpath("(//span[@class='mat-option-text'])[3]");
	String NroDoc = "(//input[@placeholder='N° de Documento:'])";
	String Name = "(//input[@name='nombres'])";
	String firstSurname = "(//input[@name='apellidoPaterno'])";
	String secondSurname = "(//input[@name='apellidoMaterno'])";
	private By SearchButton = By.xpath("(//button[@class='br-button-add'])");
	private String SearchResult = "(//div[@class='toast-top-right'])";
	private By ButtonRegre = By.xpath("(//button[@class='br-boton-regresar'])");
	
	/*##Metodos##*/
	
	public NursingPage Igotothenursingmodule() throws InterruptedException, IOException {

		seleniumUtils.click(EnterNursing);
		Thread.sleep(2000);
		seleniumUtils.AssertElementPresent(Search);
		System.out.println(seleniumUtils.getText(Search)+ " present");
		Thread.sleep(2000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new NursingPage(driver);
	}
	public NursingPage igogoingtofillintheformdataNursing(String NroDocumento, String name, String surname, String secondsurname) throws IOException, InterruptedException {
		
		seleniumUtils.click(Area);
		seleniumUtils.click(SurgicalCenter);
		Thread.sleep(5000);
		seleniumUtils.AssertElementPresent(Service);
		seleniumUtils.click(Service);
		seleniumUtils.click(RoomUCI);
		seleniumUtils.AssertElementPresent(TipoDocumento);
		seleniumUtils.click(TipoDocumento);
		seleniumUtils.click(DNI);
		System.out.println(seleniumUtils.getText(DNI)+ " present");
		Thread.sleep(5000);
		driver.findElement(By.xpath(NroDoc)).sendKeys(NroDocumento);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Name)).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath(firstSurname)).sendKeys(surname);
		Thread.sleep(1000);
		driver.findElement(By.xpath(secondSurname)).sendKeys(secondsurname);
		Thread.sleep(1000);
		seleniumUtils.click(SearchButton);
		Thread.sleep(5000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new NursingPage(driver);
		
   }  
	public NursingPage verifyMessageNursing(String message) throws Exception {
		
		String message_xpath = util.replaceText(SearchResult, message);
		if (seleniumUtils.ElementExists(By.xpath(message_xpath))) {
			System.out.println("The message warning exists");
		} else{
			System.out.println("The message warning doesnt exists");
		}
		seleniumUtils.AssertElementPresent(ButtonRegre);
		seleniumUtils.click(ButtonRegre);
		Thread.sleep(5000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new NursingPage(driver);
	}

}
