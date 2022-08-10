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

public class AdmissionPage extends WebPage{

	public AdmissionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private By EnterAdmision = By.xpath("(//h5[@class='card-title'])[1]");
	private By SearchPaciente = By.xpath("(//div[@class='mat-card-header-text'])[1]");
	private By TipoDocumento = By.xpath("(//div[@class='mat-select-arrow'])[1]");
	private By CarnetExtra = By.xpath("(//span[@class='mat-option-text'])[2]");
	String NroDoc = "(//input[@autocomplete='off'])[1]";
	String Name = "(//input[@autocomplete='off'])[2]";
	String firstSurname = "(//input[@autocomplete='off'])[3]";
	private By ResultAtenc = By.xpath("(//div[@class='mat-select-arrow'])[2]");
	private By Atencion = By.xpath("(//span[@class='mat-option-text'])[2]");
	private By SearchButton = By.xpath("(//button[@type='button'])[1]");
	private String SearchResult = "(//div[@class='toast-top-right'])";
	private By ButtonRegre = By.xpath("(//button[@class='br-boton-regresar'])");
	
	/*##Metodos##*/
	
	public AdmissionPage Igototheadmissionsection() throws InterruptedException, IOException {

		seleniumUtils.click(EnterAdmision);
		Thread.sleep(2000);
		seleniumUtils.AssertElementPresent(SearchPaciente);
		System.out.println(seleniumUtils.getText(SearchPaciente)+ " present");
		Thread.sleep(2000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new AdmissionPage(driver);
	}
	public AdmissionPage igogoingtofillintheformdata(String NroDocumento, String nombre, String apellido) throws IOException, InterruptedException {
		
		seleniumUtils.AssertElementPresent(TipoDocumento);
		seleniumUtils.click(TipoDocumento);
		seleniumUtils.click(CarnetExtra);
		System.out.println(seleniumUtils.getText(CarnetExtra)+ " present");
		Thread.sleep(5000);
		driver.findElement(By.xpath(NroDoc)).sendKeys(NroDocumento);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Name)).sendKeys(nombre);
		Thread.sleep(1000);
		driver.findElement(By.xpath(firstSurname)).sendKeys(apellido);
		Thread.sleep(1000);
		seleniumUtils.AssertElementPresent(ResultAtenc);
		seleniumUtils.click(ResultAtenc);
		seleniumUtils.click(Atencion);
		System.out.println(seleniumUtils.getText(Atencion)+ " present");
		seleniumUtils.click(SearchButton);
		Thread.sleep(5000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new AdmissionPage(driver);
		
	}
	public AdmissionPage verifyExistingMessage(String message) throws Exception {
		String messageSearchResult_xpath = util.replaceText(SearchResult, message);
		if (seleniumUtils.ElementExists(By.xpath(messageSearchResult_xpath))) {
			System.out.println("The message warning exists");
		} else{
			System.out.println("The message warning doesnt exists");
		}
		seleniumUtils.AssertElementPresent(ButtonRegre);
		seleniumUtils.click(ButtonRegre);
		Thread.sleep(5000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new AdmissionPage(driver);
	}

}
