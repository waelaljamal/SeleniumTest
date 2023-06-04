import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class SearchPage extends PageBase {

    private By searchBarLocator = By.xpath("//input[@class='search-create-all-maps-input holdkey']");
    private By xMarkLocator = By.xpath("//*[@id='closeTemplateGallery']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void doSomeSearch(String keyword) {

        // Form sending with user (search)
        fillInputTextFiled(searchBarLocator, keyword);

        // close the result slide
        clickElement(xMarkLocator);
    }

}
