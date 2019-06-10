package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PO for email messages Inbox page
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

    @FindBy(xpath = "//span[@role='checkbox']")
    private WebElement selectAllMessagesCheckbox;

    @FindBy(xpath = "//div[@data-tooltip='Inbox']//div[@class='bsU']")
    private WebElement numberOfEmailMessagesLbl;


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

    public void deleteAllAvailableIncomeMessages() {
        while (!isIncomingMessageListEmpty()){
            selectAllMessagesCheckbox.click();
            topPanelActionBtns.get(2).click();
        }
    }

    // **** GETTER's ****

    public Integer getNumberOfIncomingEmailMessages(){
        int result = 0;
        try {
            setImplicitWaitToZero();
            result = Integer.valueOf(numberOfEmailMessagesLbl.getText());
            setImplicitWaitToDefault();
            return result;
        } catch (NoSuchElementException e){
            setImplicitWaitToDefault();
            return result;
        } catch (StaleElementReferenceException e){
            setImplicitWaitToDefault();
            return result;
        }
    }

    public String getPopupMessageTxt(){
        return popupMessage.getText();
    }

    public List<String> getIncomingEmailTitles(){
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < emailMessageItems.size(); i++){
            if (i%2!=0){
                titles.add(emailMessageItems.get(i).getText());
            }
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
