package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.AccountListPage;
import pages.ContactListPage;
import pages.NewAccountModalPage;
import pages.NewContactModalPage;
import utils.TestListener;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
abstract class BaseTest {
    WebDriver driver;
    AccountListPage accountListPage;
    ContactListPage contactListPage;
    NewAccountModalPage newAccountModalPage;
    NewContactModalPage newContactModalPage;

    /**
     * Actions performed before each test
     */
    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        initPages();
    }

    /**
     * Actions performed after each test
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    /**
     * Initializing pages
     */
    public void initPages() {
        accountListPage = new AccountListPage(driver);
        contactListPage = new ContactListPage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        newContactModalPage = new NewContactModalPage(driver);
    }
}
