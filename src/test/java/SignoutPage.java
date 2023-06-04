import org.junit.*;
import org.openqa.selenium.*;

class SignoutPage extends PageBase {

    private By profileImageLocator = By.xpath("//a[@class='more-user-action-toggle']/img[@class='profile-picture']");
    private By logoutButtonLocator = By.xpath("//input[@id='logoutSubmitBtn' and @type='submit']");
    private By logoutCheckerLocatoe = By.xpath("//div[@id='linkedinContainer']//h1");

    public SignoutPage(WebDriver driver) {
        super(driver);
    }

    public void DoSignout() {

        clickElement(profileImageLocator);
        clickElement(logoutButtonLocator);
    }

    void checkSingout() {
        
        // static webpage
        WebElement logoutChecker = waitAndReturnElement(logoutCheckerLocatoe);
        Assert.assertTrue(logoutChecker.getText().contains("Thank you for being with us!"));
    }

}
