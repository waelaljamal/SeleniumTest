import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class MainPage extends PageBase {

    private By footerBy = By.className("//p[@id='copyrightMindomo']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
}
