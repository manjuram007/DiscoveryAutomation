	package com.discovery.automation.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.discovery.automation.ConfigFileReader;
import com.discovery.automation.WebDriverManager;
import com.discovery.automation.pageobjects.DiscoveryObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.junit.Cucumber;

public class DiscoveryPage{
	WebDriver driver;
	ConfigFileReader configfileReader = new ConfigFileReader();
	WebDriverManager webDriverManager;
	DiscoveryObject discoveryhomepage;

	//Getting the driver and navigating to the Discovery home page
	@Given("^User navigate to Discovery home page$")
	public void user_navigate_to_Discovery_home_page() {
		webDriverManager= new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get(configfileReader.getApplicationUrl("homepageurl"));
		DiscoveryObject discoveryhomepage = new DiscoveryObject(driver);
		discoveryhomepage.userOnDiscoveryHomePage();

	}

	//Scroll till recommended option
	@Then("^Scroll to Recommened For You section$")
	public void scroll_to_Recommened_For_You_section() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		discoveryhomepage= new DiscoveryObject(driver);

		//scroll only if element is not visible
		if(!(discoveryhomepage.recommendedForYou.isDisplayed()))
			discoveryhomepage.scrolldowntorecommendedForYouSection(discoveryhomepage.recommendedForYou);
	}

	//Add videos to favorites
	@Then("^Hover on video and Click on Add to Favorites plus Button$")
	public void hover_on_video_and_Click_on_Add_to_Favorites_plus_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		discoveryhomepage = new DiscoveryObject(driver);
		discoveryhomepage.addFirstVideoToFavList();
		discoveryhomepage.addSecondVideoToFavList();

	}

	//Navigate to the My-videos page and scrolling up till descovery logo 
	@When("^User navigate to my-videos page$")
	public void user_navigate_to_my_videos_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(configfileReader.getApplicationUrl("fevoriteurl"));
		discoveryhomepage.scrollUpword();
	}

	@Then("^Search for Favorite Shows title$")
	public void search_for_Favorite_Shows_title() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Scroll only if elemen is not visible
		if(!(discoveryhomepage.fevoriteshowsmyVideospage.isDisplayed()))
			discoveryhomepage.scrolldowntFevorite(discoveryhomepage.fevoriteshowsmyVideospage);
	}

	@Then("^Validate videos appear with the correct show title and description$")
	public void validate_videos_appear_with_the_correct_show_title_and_description() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		discoveryhomepage.verifyVideosandTitleDesc();
		webDriverManager.closeDriver();

	}


}
