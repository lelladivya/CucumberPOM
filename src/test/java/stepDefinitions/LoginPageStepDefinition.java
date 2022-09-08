package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import AppHooks.ApplicationHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition  {
	
	
	LoginPage loginPage=new LoginPage(DriverFactory.getDriver());

	@Given("user is in login page {string}")
	
	public void user_is_in_login_page(String expectedTitle) {
		String Actualtitle=loginPage.getTitle();
		if(Actualtitle.equals(Actualtitle)) {
			System.out.println("title of the login page is : "+Actualtitle);
		}
	}


	@When("user enters valid email id {string}")
	public void user_enters_valid_email_id(String emailId) {
		loginPage.enterEmailId(emailId);
	}

	@When("user enters valid password {string}")
	public void user_enters_valid_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		loginPage.doClickOnLoginBtn();
	}

	@Then("user logged into the application and {string} page appears")
	public void user_logged_into_the_application_and_page_appears(String title) {
		String expectedTitle=title;
		String actualTitle=loginPage.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	
	//scenario2
	@When("user enters emailid {string}")
	public void user_enters_leeladivya(String emailid) {
		loginPage.enterEmailId(emailid);
	}

	@When("user enters password {string}")
	public void user_enters(String password) {
		loginPage.enterPassword(password);
	}

	@Then("error message {string} should appear")
	public void error_message_should_appear(String errormesssage) {
		String actualErrorMsg=loginPage.getErrorMessage();
		Assert.assertEquals(actualErrorMsg, errormesssage);
	}

	




}
