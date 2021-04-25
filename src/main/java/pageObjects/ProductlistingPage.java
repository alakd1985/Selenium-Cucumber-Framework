package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductlistingPage {
	public ProductlistingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add to cart')]")
	private WebElement btn_AddToCart;

	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;

	@FindBy(how = How.XPATH, using = "View cart")
	private WebElement btn_ViewCart;
	@FindBy(how = How.ID, using = "pa_size")
	private WebElement btn_Size;
	@FindBy(how = How.ID, using = "pa_color")
	private WebElement btn_Color;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'checkout-button button alt wc-forward')]")
	private WebElement btn_ProceedtoCheckout;

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}

	public void clickOn_ViewCart() {
		btn_ViewCart.click();
	}

	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}

	public void clickOn_ProceedtoCheckout() {
		btn_ProceedtoCheckout.click();
	}

	public void select_DressSize() {
		Select select = new Select(btn_Size);
		select.selectByIndex(1);
	}

	public void select_DressColor() {
		Select select = new Select(btn_Color);
		select.selectByIndex(1);
	}
}
