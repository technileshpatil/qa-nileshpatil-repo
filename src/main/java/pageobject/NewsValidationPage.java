package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.Wait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsValidationPage {

    @FindBy(name = "q")
    private WebElement GOOGLE_BING_SEARCH_BOX;

    @FindBy(name = "p")
    private WebElement YAHOO_SEARCH_BOX;

    @FindBy(css = "h3.LC20lb.DKV0Md")
    private List<WebElement> GOOGLE_SEARCH_RESULTS;

    @FindBy(css = "h2 a")
    private List<WebElement> BING_SEARCH_RESULTS;

    @FindBy(css = "h3.title a")
    private List<WebElement> YAHOO_SEARCH_RESULTS;

    private final WebDriver webDriver;
    private Map<String, Integer> similarArticlesCountMap;

    public NewsValidationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
        similarArticlesCountMap = new HashMap<>();
    }
    public void searchOnGoogle(String searchQuery) {
        webDriver.get("https://www.google.com");
        Wait.untilPageReadyState(webDriver, Duration.ofSeconds(5));
        GOOGLE_BING_SEARCH_BOX.sendKeys(searchQuery);
        GOOGLE_BING_SEARCH_BOX.sendKeys(Keys.RETURN);
        similarArticlesCountMap.put("Google", GOOGLE_SEARCH_RESULTS.size());
    }
    public void searchOnBing(String searchQuery) {
        webDriver.get("https://www.bing.com");
        Wait.untilPageReadyState(webDriver, Duration.ofSeconds(5));
        GOOGLE_BING_SEARCH_BOX.sendKeys(searchQuery);
        GOOGLE_BING_SEARCH_BOX.sendKeys(Keys.RETURN);
        similarArticlesCountMap.put("Bing", BING_SEARCH_RESULTS.size());
    }
    public void searchOnYahoo(String searchQuery) {
        webDriver.get("https://www.yahoo.com");
        Wait.untilPageReadyState(webDriver, Duration.ofSeconds(5));
        YAHOO_SEARCH_BOX.sendKeys(searchQuery);
        YAHOO_SEARCH_BOX.sendKeys(Keys.RETURN);
        similarArticlesCountMap.put("Yahoo", YAHOO_SEARCH_RESULTS.size());
    }
    public Map<String, Integer> getSimilarArticlesCountMap() {
        return similarArticlesCountMap;
    }
}
