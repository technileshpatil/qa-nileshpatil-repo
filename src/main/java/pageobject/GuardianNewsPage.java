package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GuardianNewsPage {
    @FindBy(css = ".inline-the-guardian-logo.inline-logo")
    private WebElement NEWS_HEADER_LOGO;
    @FindBy(xpath = "(//div[@class='fc-item__container'])[1]/a")
    private WebElement GET_FIRST_NEWS_ARTICLE;
    public GuardianNewsPage(WebDriver webDriver){
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }
    public boolean defaultGuardianNewsHomePageIsDisplayed(){ NEWS_HEADER_LOGO.isDisplayed(); return true; }
    public String getArticleNewsLink() { return GET_FIRST_NEWS_ARTICLE.getAttribute("text"); }

}
