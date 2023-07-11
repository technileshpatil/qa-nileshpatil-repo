package stepdefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import pageobject.GuardianNewsPage;
import pageobject.NewsValidationPage;
import utils.TestContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class NewsValidationStepDefinitions {

    GuardianNewsPage guardianNewsPage;
    NewsValidationPage newsValidationPage;
    TestContext testContext;
    private Map<String, Integer> similarArticlesCountMap;

    String firstArticle;

    public NewsValidationStepDefinitions(TestContext context) {
        testContext = context;
        guardianNewsPage = testContext.getPageObjectManager().getHomePage();
        newsValidationPage = testContext.getPageObjectManager().getSearchEngineNewsListPage();
        similarArticlesCountMap = new HashMap<>();
   }

    @Given("I am on The Guardian news website")
    public void iAmOnTheGuardianNewsWebsite() {
        Assert.assertTrue(guardianNewsPage.defaultGuardianNewsHomePageIsDisplayed());
    }

    @When("I read the title of the first news article")
    public void iReadTheTitleOfTheFirstNewsArticle() {
        firstArticle = guardianNewsPage.getArticleNewsLink();
        System.out.println(firstArticle);
    }

    @And("I search for similar information on {string}")
    public void iSearchForSimilarInformationOnSearchEngine(String searchEngine) {
        firstArticle = guardianNewsPage.getArticleNewsLink();
        switch (searchEngine.toLowerCase()) {
            case "google":
                newsValidationPage.searchOnGoogle(firstArticle);
                break;
            case "bing":
                newsValidationPage.searchOnBing(firstArticle);
                break;
            case "yahoo":
                newsValidationPage.searchOnYahoo(firstArticle);
                break;
            default:
                throw new IllegalArgumentException("Invalid search engine: " + searchEngine);
        }
    }

    @Then("I should find at least {int} similar articles on {string}")
    public void iShouldFindAtLeastSimilarArticlesOn(int minCount, String searchEngine) {
        int similarArticlesCount = similarArticlesCountMap.getOrDefault(searchEngine, 0);
        assertTrue(similarArticlesCount >= minCount);
    }

    @And("I consider the first Guardian news article to be valid")
    public void iConsiderTheFirstGuardianNewsArticleToBeValid() {
        boolean isValid = false;
        for (int count : similarArticlesCountMap.values()) {
            if (count >= 1) {
                isValid = true;
                break;
            }
        }
        assertTrue(isValid);
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
       System.out.println("Close Browser");
        testContext.getDriverManager().closeDriver();
    }
}
