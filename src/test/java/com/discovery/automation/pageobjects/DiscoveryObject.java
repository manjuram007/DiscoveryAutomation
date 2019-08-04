/*This class is having all the page elements and related methods
 * present on pages
 * */
package com.discovery.automation.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class DiscoveryObject {
	public WebDriver driver;
	public Actions actions;
	String homepagetitleone,homepagedescone,homepagetitletwo,homepagedesctwo;
	String myvideospagetitleone,myvideosdescone,myvideospagetitletwo,myvideospagedesctwo;

	public DiscoveryObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='headerMain__topWrapper']/a")
	private WebElement discoveryLogo;

	@FindBy(how = How.XPATH, using ="//*[contains(text(),'Recommended')]")
	public WebElement recommendedForYou;

	@FindBy(how = How.XPATH, using ="//a[@href='/tv-shows/shark-week']//parent::div[@class='content-box showTileSquare__contentBox']")
	private WebElement firstVideo;

	@FindBy(how = How.XPATH, using ="//a[@href='/tv-shows/naked-and-afraid-xl']//parent::div[@class='content-box showTileSquare__contentBox']")
	private WebElement secondvideo;

	@FindBy(how = How.XPATH, using = "//a[@href='/tv-shows/shark-week']//i")
	private WebElement firstvideoPlus;

	@FindBy(how = How.XPATH, using ="//a[@href='/tv-shows/naked-and-afraid-xl']//i")
	private WebElement secondvideoPlus;

	@FindBy (how=How.XPATH,using="//a[@href='/tv-shows/shark-week']//h3/div")
	private WebElement getfirstVideoTitleHomepage;

	@FindBy (how=How.XPATH,using="//a[@href='/tv-shows/shark-week']/div/div[1]/div")
	private WebElement getfirstVideoDescHomepage;

	@FindBy (how=How.XPATH,using="//a[@href='/tv-shows/naked-and-afraid-xl']//h3/div")
	private WebElement getsecondVideoTitleHomepage;

	@FindBy (how=How.XPATH,using="//a[@href='/tv-shows/naked-and-afraid-xl']/div/div[1]/div")
	private WebElement getsecondVideoDescHomepage;

	@FindBy (how=How.XPATH,using="//div[@class='localStorageCarousel__wrapper']//h2")
	public WebElement fevoriteshowsmyVideospage;



	//verify whether discovery logo is displaying or not homepage after navigation
	public void userOnDiscoveryHomePage() {
		Assert.assertTrue("User is on Not on Discovery Home Page", discoveryLogo.isDisplayed());
	}

	//Scrolling down till recommended videos
	public void scrolldowntorecommendedForYouSection(WebElement ele) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Assert.assertTrue("User fail to scroll to Recommened for you section", ele.isDisplayed());
	}

	//Click on add to favorite icon after mouse hovering on element && taking title name and desc to verify on my-videos page
	public void addFirstVideoToFavList() {
		actions=new Actions(driver);
		actions.moveToElement(firstVideo).build().perform();
		Assert.assertTrue("User is not able to see the first video under recommnded", firstVideo.isDisplayed());

		homepagetitleone=getfirstVideoTitleHomepage.getText();
		Assert.assertNotNull("Not able to get Homepage title for first video", homepagetitleone);

		homepagedescone=getfirstVideoDescHomepage.getText();
		Assert.assertNotNull("Not able to get Homepage Description for first video", homepagedescone);

		firstvideoPlus.click();

	}

	//Click on add to favorite icon for second video 
	public void addSecondVideoToFavList() {
		actions=new Actions(driver);
		actions.moveToElement(secondvideo).build().perform();
		Assert.assertTrue("User is not able to see second video under recommnded", secondvideo.isDisplayed());

		homepagetitletwo=getsecondVideoTitleHomepage.getText();
		Assert.assertNotNull("Not able to get Homepage title for second video", homepagetitletwo);


		homepagedesctwo=getsecondVideoDescHomepage.getText();
		Assert.assertNotNull("Not able to get Homepage Description for second video", homepagedesctwo);


		secondvideoPlus.click();
	}

	//scroll to 0th position on my-vidoes page 
	public void scrollUpword()
	{
		((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,-2000)");
		Assert.assertTrue("User is on Not on Discovery Home Page", discoveryLogo.isDisplayed());

	}

	//Scroll down Till My favorite shows
	public void scrolldowntFevorite(WebElement ele) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Assert.assertTrue("User fail to scroll to Recommened for you section", ele.isDisplayed());
	}

	//verify the videos title and description for validation
	public void verifyVideosandTitleDesc()
	{
		actions=new Actions(driver);
		actions.moveToElement(firstVideo).build().perform();
		Assert.assertTrue("Video is not present under fevorites", firstVideo.isDisplayed());

		myvideospagetitleone=getsecondVideoTitleHomepage.getText();
		Assert.assertNotNull("Not able to get MyvideosPage title for first video", myvideospagetitleone);


		myvideosdescone=getsecondVideoDescHomepage.getText();
		Assert.assertNotNull("Not able to get MyvideosPage Description for first video", myvideosdescone);

		actions.moveToElement(secondvideo).build().perform();
		myvideospagetitletwo=getsecondVideoTitleHomepage.getText();
		Assert.assertNotNull("Not able to get MyvideosPage title for second video", myvideospagetitleone);


		myvideospagedesctwo=getsecondVideoDescHomepage.getText();
		Assert.assertNotNull("Not able to get MyvideosPage Description for second video", myvideospagedesctwo);

		if(homepagetitleone.contains(myvideospagetitleone)&& homepagedescone.contains(myvideosdescone)&&homepagetitletwo.contains(myvideospagetitletwo)&&homepagedesctwo.contains(myvideospagedesctwo))
		{
			System.out.println("Validation is completed");


		}
	}

}


