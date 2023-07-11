package Managers;

import org.openqa.selenium.WebDriver;
import pageobject.GuardianNewsPage;
import pageobject.NewsValidationPage;

public class PageObjectManager {

    private final WebDriver webDriver;
    private GuardianNewsPage guardianNewsPage;
    private NewsValidationPage newsValidationPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public GuardianNewsPage getHomePage() {
        return (guardianNewsPage == null) ? guardianNewsPage = new GuardianNewsPage(webDriver) : guardianNewsPage;
    }

    public NewsValidationPage getSearchEngineNewsListPage() {
        return (newsValidationPage == null) ? newsValidationPage = new NewsValidationPage(webDriver) : newsValidationPage;
    }

}
