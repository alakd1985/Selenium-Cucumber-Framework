package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
	TestContext testContext;
	CheckoutPage checkoutPage;

	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}

	@When("^enter \"([^\"]*)\" personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(String customerName) {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.fill_PersonalDetails(customer);
	}

	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		// testContext.getWebDriverManager().closeDriver();
	}

}
