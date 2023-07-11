package utils;

import enums.ContextValidate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nilesh Patil
 * @created 09/07/2023 - 21:43
 */
public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(ContextValidate key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(ContextValidate key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(ContextValidate key) {
        return scenarioContext.containsKey(key.toString());
    }
}

