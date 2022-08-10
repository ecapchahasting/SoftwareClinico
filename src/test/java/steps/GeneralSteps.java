package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.HomePage;
import pages.LoginPage;
import pages.AdmissionPage;
import pages.SurgucalCenterPage;
import pages.NursingPage;

public class GeneralSteps {
	final Logger LOGGER = LoggerFactory.getLogger(GeneralSteps.class);
	WebDriver driver;
	DriverFactory driverFactory;
	HomePage home;
	LoginPage login;
	AdmissionPage admission;
	SurgucalCenterPage surgical;
	NursingPage nursing;
	
	public void setup() throws IOException{
		driverFactory= new DriverFactory();
		driverFactory.getDriver(ConfigProp.getBrowser());
		driver= driverFactory.driver();	
		home = new HomePage(driver);
		login = new LoginPage(driver);
		admission = new AdmissionPage(driver);
		surgical = new SurgucalCenterPage(driver);
		nursing = new NursingPage(driver);
		LOGGER.info("@BeforeTest- Setup");
	}
	
	public void tearDown(){
		driverFactory.tearDown();
		LOGGER.info("@AfterTest- tearDown");
	}
	
	@Before
	public void beforeScenario() throws IOException {
		setup();
	}
	
	@After
	public void afterScenario() {
		tearDown();
	}
	
	@Step("I open the T-Integro")
	@Given("^I open the T-Integro$")
	   public void GoToOpenUrl() throws InterruptedException, IOException{
		login.goToOpenUrl();
	   }
	
	@Step("I Login to T-Integro with email {Username} and password {Password}")
	@When("^I Login to T-Integro with email (.*) and password (.*)$")
	public void loginToTIntegro(String email, String password) throws InterruptedException, IOException{
		login.LoginToTIntegro(email, password);
	   } 
	
	@Step("I go validate username")
	@Then("^I go validate username$")
	   public void IgoValidateUsername() throws InterruptedException, IOException{
		home.igoValidateUsername();
	   }
	@Step("I go will Validate the Modules")
	@Then("^I go will Validate the Modules$")
	   public void IgowillValidateModules() throws InterruptedException, IOException{
		home.igowillValidateModules();
	   }
	@Step("I go to the admission module")
	@Then("^I go to the admission module$")
	   public void igototheadmissionsection() throws InterruptedException, IOException{
		admission.Igototheadmissionsection();
	   }
	@Step("I will fill in the data with the Document {NroDocumento} Name {nombre} and first surname {apellido}")
	@Then("^I will fill in the data with the Document (.*) Name (.*) and first surname (.*)$")
	   public void Igogoingtofillintheformdata(String NroDocumento, String nombre, String apellido) throws InterruptedException, IOException{
		admission.igogoingtofillintheformdata(NroDocumento, nombre,apellido);
	   }
	@Step("I verify the message exists: '{message}'")
	@And("^I verify the message exists: '(.*)'$")
	public void verifyExistingMessage(String message) throws Exception{
		admission.verifyExistingMessage(message);
	}
	@Step("I go to the Surgical Center Module")
	@Then("^I go to the Surgical Center Module$")
	   public void igototheSurgicalentergmodule() throws InterruptedException, IOException{
		surgical.IgototheSurgicalentergmodule();
	   }
	@Step("I go going to search for room programming in the surgical center module")
	@Then("^I go going to search for room programming in the surgical center module$")
	   public void Igogoingtolookforaroominthesurgicalcentermodule() throws InterruptedException, IOException{
		surgical.igogoingtolookforaroominthesurgicalcentermodule();
	   }
	@Step("I go verify the message exists: '{message}'")
	@And("^I go verify the message exists: '(.*)'$")
	public void verifyMessage(String message) throws Exception{
		surgical.verifyMessage(message);
	}
	@Step("I go to the nursing module")
	@Then("^I go to the nursing module$")
	   public void igotothenursingmodule() throws InterruptedException, IOException{
		nursing.Igotothenursingmodule();
	   }
	@Step("I go will fill in the data with the Document {NroDocumento} Name {name} and first surname {surname} and second surname {secondsurname}")
	@Then("^I go will fill in the data with the Document (.*) Name (.*) and first surname (.*) and second surname (.*)$")
	   public void IgogoingtofillintheformdataNursing(String NroDocumento, String name, String surname, String secondsurname) throws InterruptedException, IOException{
		nursing.igogoingtofillintheformdataNursing(NroDocumento, name,surname, secondsurname);
	   }
	@Step("I will verify that the search message: '{message}'")
	@And("^I will verify that the search message: '(.*)'$")
	public void verifyMessageNursing(String message) throws Exception{
		nursing.verifyMessageNursing(message);
	}
	
	
	
	
}
