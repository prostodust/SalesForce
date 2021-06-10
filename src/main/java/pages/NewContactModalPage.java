package pages;

import org.openqa.selenium.WebDriver;

public class NewContactModalPage extends BasePage {

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    //TODO: Implement this method
}