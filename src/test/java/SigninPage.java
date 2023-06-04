import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class SigninPage extends PageBase {

    private By loginPageButtonLocator = By.xpath("//a[@class='btn btn-gray btn-medium' and @href='/login']");
    private By mailBoxLocator = By.xpath("//input[@id='username']");
    private By passwordBoxLocator = By.xpath("//input[@id='password']");
    private By loginButtonLocator = By.xpath("//button[@id='login']");

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    // Fill simple form and send (Login)
    public void DoSignin(String id, String password) {

        clickElement(loginPageButtonLocator);
        fillInputTextFiled(mailBoxLocator, id);
        fillInputTextFiled(passwordBoxLocator, password);
        clickElement(loginButtonLocator);
    }

    void checkSingin() {

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mindomo.com/dashboard";
        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
