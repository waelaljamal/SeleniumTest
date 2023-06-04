import org.openqa.selenium.*;

public class UpdateAboutMePage extends PageBase {

    private By textareaLocator = By.xpath("//table[@id='personalInfoTable']//textarea[@id='aboutMe']");
    private By updateDetailsLocator = By.xpath("//table[@id='personalInfoTable']//input[@id='update']");

    public UpdateAboutMePage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.mindomo.com/account.htm#personal-info");
    }

    public void setAndGetTextarea() {

        // dublicate its contents
        WebElement aboutMe = waitAndReturnElement(textareaLocator);
        aboutMe.sendKeys(" " + aboutMe.getAttribute("value"));

        clickElement(updateDetailsLocator);

    }
}
