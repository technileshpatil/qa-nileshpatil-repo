package utils;

import Managers.DriverManager;
import Managers.PageObjectManager;

/**
 * @author Nilesh Patil
 * @created 09/07/2023 - 21:52
 */
public class TestContext {

    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
