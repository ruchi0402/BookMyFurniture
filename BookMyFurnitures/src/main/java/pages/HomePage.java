package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.CommonMethods;

public class HomePage extends CommonMethods {
	Logger log = Logger.getLogger(HomePage.class);

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

	@FindBy(xpath = "//h3[contains(text(),' Enjoy the home decor at cheapest rate possible ever. ')]//button[contains(text(), 'Book Now')]")
	private WebElement bookNowBTN;

	@FindBy(xpath = "//h3[@class='navbar-brand']")
	private WebElement logo;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void validateHomePageTitle() {
		try {
			if (driver.getTitle() == "Book My Furniture - QA(2.3.2)-Final")
				;
			log.info("Title matches");
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}

	public void ValidateLogoImage() {

		isDisplayed(logo, "Logo is displayed correctly");
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
