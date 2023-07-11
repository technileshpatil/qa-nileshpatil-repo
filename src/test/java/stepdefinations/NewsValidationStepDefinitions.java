package stepdefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import pageobject.GuardianNewsPage;
import pageobject.NewsValidationPage;
import utils.TestContext;


import static org.testng.Assert.assertTrue;

public class NewsValidationStepDefinitions {

    GuardianNewsPage guardianNewsPage;
    NewsValidationPage newsValidationPage;
    TestContext testContext;
    String firstArticle;

    public NewsValidationStepDefinitions(TestContext context) {
        testContext = context;
        guardianNewsPage = testContext.getPageObjectManager().getHomePage();
        newsValidationPage = testContext.getPageObjectManager().getSearchEngineNewsListPage();
   }

    @Given("I am on The Guardian news website")
    public void iAmOnTheGuardianNewsWebsite() {
        assertTrue(guardianNewsPage.defaultGuardianNewsHomePageIsDisplayed());
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
    @Then("I should find at least similar articles on {string}")
    public void iShouldFindAtLeastSimilarArticlesOn(String searchEngine) {
        assertTrue(newsValidationPage.compareSearch(firstArticle, searchEngine) >=1);
    }
    @And("I consider the first Guardian news article to be valid")
    public void iConsiderTheFirstGuardianNewsArticleToBeValid() {
        assertTrue(newsValidationPage.isArticleValidCheck());
    }
    @And("I close the browser")
    public void iCloseTheBrowser() {
       System.out.println("Close Browser");
    }

}
