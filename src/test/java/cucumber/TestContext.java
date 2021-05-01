package cucumber;

import managers.PageObjectManager;
import managers.Webdrivermanager;

public class TestContext {
	private Webdrivermanager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;

	public TestContext() {
		webDriverManager = new Webdrivermanager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public Webdrivermanager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}
