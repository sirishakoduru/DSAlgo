package dsalgo_stepdefinition;

import java.util.Arrays;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import dsalgo_DriverFactory.DriverFactory;
import dsalgo_Utilities.LoggerLoad;
import dsalgo_Utilities.configReader;

import dsalgo_pageobjects.Home_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage_step {
	
	private configReader reader = new configReader();
	private WebDriver driver = DriverFactory.getDriver();
	private Home_page homepage = new Home_page(driver);
	
//@Homepage_01
	@Given("The user should open the browser")
	public void the_user_should_open_the_browser() {
	    
		DriverFactory.getDriver();
	   
	}

	@When("The user enter the DS_Algo Portal link")
	public void the_user_enter_the_ds_algo_portal_link() {
		
		LoggerLoad.info("portal URL: " + reader.getProperty("App_URL"));
		DriverFactory.getDriver().get(reader.getProperty("App_URL"));
	   
	}

	@Then("The user should land on the DS_Algo Get Started page with message {string}")
	public void the_user_should_land_on_the_ds_algo_get_started_page_with_message(String message) {
		
		Assert.assertTrue(message.contains(homepage.isGetStartedpage()));
		LoggerLoad.info("user can see message :Preparing for the Interviews You are at the right place");
	}
	
//@Homepage_02
	@Given("The user is able to open the DS Algo Portal URL in any supported browser")
	public void the_user_is_able_to_open_the_ds_algo_portal_url_in_any_supported_browser() {
		
		DriverFactory.getDriver().get(reader.getProperty("App_URL"));

	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String Getstarted) {
	    
		homepage.click_getstarted();
	}

	@Then("The user should land in Data Structure Introduction Page with {string} and {string} links")
	public void the_user_should_land_in_data_structure_introduction_page_with_and_links(String string, String string2) {
//	    TODO: Write Assertion checking all home page elements.
		
		Assert.assertEquals(driver.getTitle(), "NumpyNinja");
		LoggerLoad.info("user can see the title :***" +(homepage.hometitle())+ "****");
		Assert.assertEquals(homepage.getTotalDataStructureCards(),7);
		
		
	}
//@Homepage_03
	@Given("The user is on the Data Structure introduction page")
	public void the_user_is_on_the_data_structure_introduction_page() {
		
		DriverFactory.getDriver().get(reader.getProperty("Home_URL"));
	
	}

	@When("The user clicks the data structure\"dropdown arrow\"")
	public void the_user_clicks_the_data_structure_dropdown_arrow() {
	    
		 homepage.click_dropdown();
	   
	}

	@Then("The user should able to see {int} options in dropdown menu")
	public void the_user_should_able_to_see_options_in_dropdown_menu(Integer count) {
		
	    Assert.assertEquals(homepage.getdropdowncount(),6);
	   

	}
//@Homepage_04
	@Given("The user is on the home page with {string} and {string} page")
	public void the_user_is_on_the_home_page_with_and_page(String string, String string2) {
		
		DriverFactory.getDriver().get(reader.getProperty("Home_URL"));
	   
	}
	@When("^The user selects any data structures item from the drop down without Sign in (.+)$")
    public void user_selects_data_structure_item_without_sign_in(String option) {
		
		homepage.getdropdown(option);
	}
	

	@Then("The user should able be see an alert warning message {string}")
	public void the_user_should_able_be_see_an_alert_warning_message(String message) {
	    
	   Assert.assertEquals(homepage.getalertmsg(),message);
	   LoggerLoad.info("Actul message: " +message );
	}
//@Homepage_05
	@Given("The user is on the DS Introduction page")
	public void the_user_is_on_the_ds_introduction_page() {
		
		DriverFactory.getDriver().get(reader.getProperty("Home_URL")); 
	   
	}

	@When("^The user clicks \"Get Started\" button of any on the DS Introduction page (.+)$")
    public void user_clicks_get_started_button_of_any_option(String option) {
		
		homepage.getstarted(option);
	}

	@Then("The user should able to see a warning message {string}")
	public void the_user_should_able_to_see_a_warning_message(String message) {
	 
		Assert.assertEquals(homepage.getalertmsg(),message);
		LoggerLoad.info("Actul message: " +message );
	}
//@Homepage_06
	@When("The user clicks {string} link on the DS Introduction page")
	public void the_user_clicks_link_on_the_ds_introduction_page(String string) {
	    
	   homepage.click_register();
	}

	@Then("The user should be navigated to Register form")
	public void the_user_should_be_navigated_to_register_form() {
	   
		Assert.assertEquals(homepage.registertitle(),"Registration"); 
//	   Assert.assertEquals(driver.getTitle(),"Registration");
	   Assert.assertTrue(homepage.isRegistrationButtonPresent());
	   LoggerLoad.info("user can see the title :***" +(homepage.registertitle())+ "****");
	}
	//@Homepage_07
	@When("The user clicks {string} link")
	public void the_user_clicks_link(String string) {
	    
	   homepage.click_signin();
	}

	@Then("The user should be naviagted to Sign in page")
	public void the_user_should_be_naviagted_to_sign_in_page() {
		
		Assert.assertEquals(driver.getTitle(),"Login");
		Assert.assertTrue(homepage.isloginbuttonpresent());
		LoggerLoad.info("user can see the title :***" +(homepage.signintitle())+ "****");
	}

}
