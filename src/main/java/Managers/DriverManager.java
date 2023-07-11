package Managers;

import enums.BrowserDriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;


public class DriverManager {

    private WebDriver webDriver;
    private static BrowserDriverType browserDriverType;
    private static EnvironmentType environmentType;

    public DriverManager() {
        browserDriverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }
    private WebDriver createLocalDriver() {
        switch (browserDriverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                // chromeOptions.addArguments("--headless", "--window-size=1644,868");
                chromeOptions.addArguments("--remote-debugging-port-9222", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
                webDriver = new ChromeDriver(chromeOptions);
                webDriver.manage().window().maximize();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();

        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("Missing implementation");
    }
    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
            case REMOTE:
                webDriver = createRemoteDriver();
                break;
        }
        return webDriver;
    }

    public WebDriver getDriver() {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

}
