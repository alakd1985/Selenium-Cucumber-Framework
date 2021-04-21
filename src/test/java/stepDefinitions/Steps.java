package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	WebDriver driver;

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://shop.demoqa.com/");
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for_dress(String arg1) {
		driver.navigate().to("https://shop.demoqa.com/?s=" + arg1 + "&post_type=product");
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();
		WebElement color = driver.findElement(By.id("pa_color"));
		Select select = new Select(color);
		select.selectByIndex(1);
		WebElement size = driver.findElement(By.id("pa_size"));
		Select select1 = new Select(size);
		select1.selectByIndex(1);
		WebElement cart = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
		cart.click();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() {
		WebElement viewCart = driver.findElement(By.linkText("View cart"));
		viewCart.click();

		WebElement proceedToCheckout = driver
				.findElement(By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]"));
		proceedToCheckout.click();
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() {
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Alak");
		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Dutta");
		List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
		for (WebElement country : countryList) {
			if (country.getText().equals("India")) {
				country.click();
				break;
			}
		}

	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() {
		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Shalimar Bagh");
		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("110088");

		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");

		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");
	}

	@When("^place the order$")
	public void place_the_order() {
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		driver.quit();
	}

}
