package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductlistingPage;

public class Steps {
	WebDriver driver;
	HomePage home;
	ProductlistingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://shop.demoqa.com/");
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for_dress(String product) {
		home = new HomePage(driver);
		home.perform_Search(product);
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage = new ProductlistingPage(driver);
		productListingPage.select_Product(0);
		productListingPage.select_DressColor();
		productListingPage.select_DressSize();
		productListingPage.clickOn_AddToCart();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() {
		cartPage = new CartPage(driver);
		cartPage.clickOn_ViewCart();
		cartPage.clickOn_ProceedToCheckout();

	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.fill_PersonalDetails();

	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.fill_ShippingDetails();

	}

	@When("^place the order$")
	public void place_the_order() {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.clickOn_PlaceOrder();
		driver.quit();
	}

}
