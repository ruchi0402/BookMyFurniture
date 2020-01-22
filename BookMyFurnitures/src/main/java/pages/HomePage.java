package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage {

	// Object Repository or OR or Page Factory Elements

	@FindBy(xpath = "//div[#'navbarSupportedContent']//span[@innertext=' Wishlist ']")
	private WebElement wishList;

	@FindBy(xpath = "//div[#'navbarSupportedContent']//span[@innertext=' Cart ']")
	private WebElement cart;

	@FindBy(xpath = "//div[#'navbarSupportedContent']//span[@innertext=' Support ']")
	private WebElement supportLink;

	@FindBy(xpath = "//div[@id='navbarSupportedContent']/form/button[@type='button']/span[@class='mat-button-wrapper']")
	private WebElement signInLink;

	@FindBy(xpath = "//span[@class='carousel-control-prev-icon']")
	private WebElement prevIcon;

	@FindBy(xpath = "//span[@class='carousel-control-next-icon']")
	private WebElement nextIcon;

	@FindBy(xpath = "///button[@innertext=' All Furnitures ']")
	private WebElement allFurnituresbutton;

	@FindBy(xpath = "//mat-icon[contains(text(),'search')]")
	private WebElement search;

	@FindBy(xpath = "/html//div[@id='bannerCarouselControl']/div[@class='carousel-inner']/div/div[@class='content']/h3/span/button[.=' Book Now ']")
	private WebElement bookNowBTN;

	@FindBy(xpath = "//h3[@class='navbar-brand']")
	private WebElement logo;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	// Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateLogoImage() {
		return logo.isDisplayed();
	}
	public void viewWishList() {
		click(wishList);
	}
	public void viewCart() {
		click(cart);
	}
	public void clickonSupport() {
		click(supportLink);
	}
	public void clickSignIn() {
		click(signInLink);	
	}
	public void viewAllFurnitures() {
		click(allFurnituresbutton);
	}
	public void clickBookNow() {
		click(bookNowBTN);
	}
}
