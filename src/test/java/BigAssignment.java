import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.Collections;

public class BigAssignment {

	private WebDriver driver;

	@Before
	public void setup() throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments(
				"--disable-blink-features=AutomationControlled",
				"--disable-infobars",
				"--no-sandbox",
				"--disable-dev-shm-usage",
				"--disable-web-security",
				"--allow-running-insecure-content",
				"--start-maximized");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
		this.driver.manage().window().maximize();
	}

	public void login() {

		this.driver.get("https://www.mindomo.com/");
		SigninPage signinPage = new SigninPage(this.driver);
		signinPage.DoSignin("wael619games@gmail.com", "0955663011");
		signinPage.checkSingin();
	}

	@Test
	public void loadMainPage() {

		this.driver.get("https://www.mindomo.com/");

		// Reading the page title
		String title = this.driver.getTitle();
		System.out.println(title);

		MainPage mainPage = new MainPage(driver);
		Assert.assertTrue(mainPage.getFooterText().contains("Expert Software Applications srl."));

	}

	@Test
	public void loginTest() {
		login();
	}

	@Test
	public void searchBarTest() {
		login();
		SearchPage searchPage = new SearchPage(driver);
		searchPage.doSomeSearch("plan\n");
	}

	@Test
	public void changeLanguageTest() {
		login();
		// base state: any language which is not English
		LanguageChange languageChange = new LanguageChange(driver);
		languageChange.setEnglishLanguage();
	}

	@Test
	public void cookieTest() {
		login();
		CookiesTesting cookiesTesting = new CookiesTesting(driver);
		cookiesTesting.testLanguageChange();
	}

	@Test
	public void uploadfileTest() {
		login();
		UploadFile uploadFile = new UploadFile(driver);
		uploadFile.uploadFile("/home/seluser/foo.txt");
	}

	@Test
	public void textAreaTest() throws InterruptedException {
		login();
		UpdateAboutMePage updateAboutMePage = new UpdateAboutMePage(driver);
		updateAboutMePage.setAndGetTextarea();
		Thread.sleep(50000);
	}

	@Test
	public void logoutTest() {
		login();
		SignoutPage signoutPage = new SignoutPage(driver);
		signoutPage.DoSignout();
		// static page after logout
		signoutPage.checkSingout();
	}

	@After
	public void close() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}

}
