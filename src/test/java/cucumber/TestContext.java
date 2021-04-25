package cucumber;

import managers.PageObjectManager;
import managers.Webdrivermanager;

public class TestContext {
	private Webdrivermanager webDriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		webDriverManager = new Webdrivermanager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public Webdrivermanager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
