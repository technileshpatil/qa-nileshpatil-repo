package locators;

import org.openqa.selenium.By;
import java.util.function.Supplier;

import static org.openqa.selenium.By.cssSelector;

// This is another way we can define locators - This is just an example, not used anywhere.
public enum MyGuardianNewsCSSExample implements Supplier<By> {

    NEWS_HEADER_LOGO(".inline-the-guardian-logo.inline-logo"),
    CURRENT_NEWS_DATE(".fc-date-headline");

    private final By by;

    MyGuardianNewsCSSExample(String css) { this.by = cssSelector(css); }

    @Override
    public By get() { return by;}

    @Override
    public String toString() { return by.toString();}

}
