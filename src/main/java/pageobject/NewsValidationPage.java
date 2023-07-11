package pageobject;

import org.openqa.selenium.By;
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
    private final WebDriver webDriver;
    int searchCounter = 0;
    @FindBy(xpath = "//*[@id=\"W0wltc\"]/div")
    private WebElement REJECT_ALL_COOKIES;
    @FindBy(xpath = "//*[contains(@href, \"theguardian\")]")
    private List<WebElement> THE_GUARDIAN_LINK;
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

   // public Map<String, Integer> similarArticlesCountMap = new HashMap<>();

    public NewsValidationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 10), this);

    }
    public void searchOnGoogle(String searchQuery) {
        webDriver.get("https://www.google.com");
        REJECT_ALL_COOKIES.click();
        Wait.untilPageReadyState(webDriver, 5L);
        GOOGLE_BING_SEARCH_BOX.sendKeys(searchQuery);
        GOOGLE_BING_SEARCH_BOX.sendKeys(Keys.RETURN);
    }
    public void searchOnBing(String searchQuery) {
        webDriver.get("https://www.bing.com");
        Wait.untilPageReadyState(webDriver, 5L);
        GOOGLE_BING_SEARCH_BOX.sendKeys(searchQuery);
        GOOGLE_BING_SEARCH_BOX.sendKeys(Keys.RETURN);
    }
    public void searchOnYahoo(String searchQuery) {
        webDriver.get("https://www.yahoo.com");
        Wait.untilPageReadyState(webDriver,5L);
        YAHOO_SEARCH_BOX.sendKeys(searchQuery);
        YAHOO_SEARCH_BOX.sendKeys(Keys.RETURN);
    }
    public int compareSearch(String searchArticle, String searchEngine) {
        int searchCounter = (int) GOOGLE_SEARCH_RESULTS.stream()
                .map(WebElement::getText)
                .filter(resultText -> resultText.contains(searchArticle.substring(10, 20)))
                .peek(resultText -> System.out.println("Direct Link: " + resultText))
                .count();
        return searchCounter;
    }
    public boolean isArticleValidCheck(){
        boolean isArticleValid = false;
        System.out.println("Direct Link:" +  THE_GUARDIAN_LINK.get(0).getText());
        for (int j = 0 ; j < GOOGLE_SEARCH_RESULTS.size(); j++)
            if (THE_GUARDIAN_LINK.get(j).getText().contains("theguardian")){
                isArticleValid = true;
                break;
            }
        return isArticleValid;
    }



}
