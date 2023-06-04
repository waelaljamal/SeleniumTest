import org.junit.*;
import org.openqa.selenium.*;

public class CookiesTesting extends PageBase {

    public CookiesTesting(WebDriver driver) {
        super(driver);
    }

    private void setUSerSettingsByCookie(String key, String value) {
        this.driver.manage().addCookie(new Cookie(key, value));
    }

    public void testLanguageChange() {

        // Cookie
        // change language settings
        String[] languagesCodes = new String[] { "du", "hu", "en" };
        for (String languageCode : languagesCodes) {
            setUSerSettingsByCookie("clientlanguage", languageCode);
            driver.navigate().refresh();
            checkLanguage(languageCode);
        }
    }

    void checkLanguage(String languageCode) {

        Cookie langCookie = driver.manage().getCookieNamed("clientlanguage");
        Assert.assertTrue(langCookie.toString().contains(languageCode));
    }

}
