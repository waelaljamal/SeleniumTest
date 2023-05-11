import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


public class SeleniumOne {
    // init
    private WebDriver driver;
    private WebDriverWait wait;

    // form data
    private final By usernameLocator = By.xpath("//input[@name='username']");
    private final By passwordLocator = By.xpath("//input[@name='password']");
    
    // buttons login/logout
    private final By submitButtonLocator = By.xpath("//button[@type='submit']");
    private final By logoutLocator = By.xpath("//a[@href='/logout']");
    
    // flash element
    private final By notificationLocator = By.xpath("//div[@id='flash']");

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    private WebElement waitVisibiiltyAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    private void enterCredintials(String username, String password){
        WebElement usernameElement = waitVisibiiltyAndFindElement(usernameLocator);
        usernameElement.sendKeys(username);
        WebElement passwordElement = waitVisibiiltyAndFindElement(passwordLocator);
        passwordElement.sendKeys(password);
    }

    private void clickLoginButton() {
        WebElement submitButtonElement = waitVisibiiltyAndFindElement(submitButtonLocator);
        submitButtonElement.click();
    }

    private void openPage(String link) {
        this.driver.get(link);
    }

    private void checkNotificationStatus(By notificationLocator, String text) {
        WebElement secureareaElement = waitVisibiiltyAndFindElement(notificationLocator);
        Assert.assertTrue(secureareaElement.getText().contains(text));
    }

    @Test
    public void loginWithRigthCredintialsTest() {
        // open the page
        openPage("http://the-internet.herokuapp.com/login");

        // enter rigth credintials
        enterCredintials("tomsmith","SuperSecretPassword!");
        
        // click login button
        clickLoginButton();
        
        // check login status
        checkNotificationStatus(notificationLocator,"You logged into a secure area!");

        // logout - click logout 
        WebElement logoutElement = waitVisibiiltyAndFindElement(logoutLocator);
        logoutElement.click();

        // check logout
        checkNotificationStatus(notificationLocator,"You logged out of the secure area!");
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        // open the page
        openPage("http://the-internet.herokuapp.com/login");

        // enter wrong password credintials
        enterCredintials("tomsmith","wrong Password!");

        // click login button
        clickLoginButton();

        // check login status - invalid password
        checkNotificationStatus(notificationLocator,"Your password is invalid!");
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        // open the page
        openPage("http://the-internet.herokuapp.com/login");

        // enter wrong username credintials + whatever password
        enterCredintials("WAEL ALJAMAL","SuperSecretPassword!");

        // click login button
        clickLoginButton();

        // check login status - invalid username
        checkNotificationStatus(notificationLocator,"Your username is invalid!");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
