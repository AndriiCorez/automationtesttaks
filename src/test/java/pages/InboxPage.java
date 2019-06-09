package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andres on 6/7/2019.
 */
public class InboxPage extends BasePage {

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // **** ELEMENTS ****

    @FindBy(xpath = "//div[@role='button' and contains(text(),'Compose')]")
    private WebElement composeEmailBtn;

    // **** ACTIONS ****

    public ComposeEmailPage clickComposeEmailButton(){
        composeEmailBtn.click();
        return new ComposeEmailPage(driver);
    }
}
