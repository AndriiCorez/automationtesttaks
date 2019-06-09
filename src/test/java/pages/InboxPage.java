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

    @FindBy(xpath = "//div[@role='checkbox']")
    private List<WebElement> receivedEmailCheckbox;

    @FindBy(xpath = "//div[@class='asa']")
    private List<WebElement> topPanelActionBtns;

    // **** ACTIONS ****

    public ComposeEmailPage clickComposeEmailButton(){
        composeEmailBtn.click();
        return new ComposeEmailPage(driver);
    }

    public InboxPage deleteFirstEmail(){
        receivedEmailCheckbox.get(0).click();
        topPanelActionBtns.get(2).click();
        return this;
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

    public int getNumberOfIncomingMessagesOnList() {
        return receivedEmailCheckbox.size();
    }

    public boolean isIncomingMessageListEmpty() {
        setImplicitWaitToZero();
        boolean result = receivedEmailCheckbox.size() == 0;
        setImplicitWaitToDefault();
        return result;
    }
}
