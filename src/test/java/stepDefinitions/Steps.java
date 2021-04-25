package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps {
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(driver);// will get null pointer exception without this step
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();

	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for_dress(String product) {

		homePage.perform_Search(product);
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {

		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.select_Product(0);
		productListingPage.select_DressColor();
		productListingPage.select_DressSize();
		productListingPage.clickOn_AddToCart();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() {
		cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_ViewCart();
		cartPage.clickOn_ProceedToCheckout();

	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() {
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.fill_PersonalDetails();

	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() {
		checkoutPage.fill_ShippingDetails();

	}

	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.clickOn_PlaceOrder();
		driver.quit();
	}

}
