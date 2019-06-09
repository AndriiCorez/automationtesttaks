package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//span[@class='bqe']")
    private List<WebElement> emailMessageItems;

    @FindBy(xpath = "//span[@class='bAq']")
    private WebElement popupMessage;

    // **** ACTIONS ****

    public ComposeEmailPage clickComposeEmailButton(){
        composeEmailBtn.click();
        return new ComposeEmailPage(driver);
    }

    // **** GETTER's ****

    public String getPopupMessageTxt(){
        return popupMessage.getText();
    }

    public List<String> getIncomingEmailTitles(){
        List<String> titles = new ArrayList<>();
        for (WebElement e : emailMessageItems){
            titles.add(e.getText());
        }
        return titles;
    }
}
