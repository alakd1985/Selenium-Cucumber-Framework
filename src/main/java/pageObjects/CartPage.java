package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;
	@FindBy(how = How.LINK_TEXT, using = "View cart")
	private WebElement btn_ViewCart;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'checkout-button button alt wc-forward')]")
	private WebElement btn_ProceedToCheckout;

	public void clickOn_Cart() {
		btn_Cart.click();
	}

	public void clickOn_ViewCart() {
		btn_ViewCart.click();
	}

	public void clickOn_ProceedToCheckout() {
		btn_ProceedToCheckout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
}
