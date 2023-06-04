import org.junit.*;
import org.openqa.selenium.*;

class LanguageChange extends PageBase {

    private By profileImageLocator = By.xpath("//a[@class='more-user-action-toggle']/img[@class='profile-picture']");
    private By languageMenuLocator = By.xpath(
            "//div[contains(@class,'dropdown-menu')]//ul[@id='usersActionContainer']//li[@id='languagesSubmenu']/a[@class='dropdown-submenu-target']");

    private By EnglishLanguageLocator = By.xpath(
            "//ul[contains(@class, 'languages-dropdown-menu')]/li[@class='language']/a[@href='/dashboard']");

    public LanguageChange(WebDriver driver) {
        super(driver);
    }

    public void setEnglishLanguage() {

        clickElement(profileImageLocator);
        clickElement(languageMenuLocator);
        clickElement(EnglishLanguageLocator);
    }

    void checkLanguage() {

        Cookie langCookie = driver.manage().getCookieNamed("clientlanguage");
        Assert.assertTrue(langCookie.toString().contains("en"));
    }

}
