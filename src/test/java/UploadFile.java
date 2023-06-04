import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class UploadFile extends PageBase {

    private By importButtonLocator = By.xpath("//div[@id='uploadBtn']");
    private By fileUploadLocator = By.xpath("//input[@id='fileupload']");

    public UploadFile(WebDriver driver) {
        super(driver);
    }

    public void makeInputElementVisible(String id) {
        
        JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("document.getElementById('" + id + "').style.display='block';");
    }

    public void uploadFile(String path) {

        clickElement(importButtonLocator);
        makeInputElementVisible("fileupload");
        fillInputTextFiled(fileUploadLocator, path);
    }

}
