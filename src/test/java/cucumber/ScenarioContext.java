package cucumber;

import java.util.HashMap;
import java.util.Map;

import enums.Context;

public class ScenarioContext {
	// private Map<String, Object> scenarioContext;
	private Map<String, String> scenarioContext;

	public ScenarioContext() {
		scenarioContext = new HashMap<>();
	}

	public void setContext(Context key, String value) {
		scenarioContext.put(key.toString(), value);
	}

	public String getContext(Context key) {
		return scenarioContext.get(key.toString());
	}

	public Boolean isContains(Context key) {
		return scenarioContext.containsKey(key.toString());
	}
}
