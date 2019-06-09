package pages;

import POJOs.EmailContent;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andres on 6/9/2019.
 */
public class ComposeEmailPage extends BasePage {

    public ComposeEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // **** ELEMENTS ****

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement receiverFld;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectFld;

    @FindBy(xpath = "//div[@aria-label='Message Body' and @role='textbox']")
    private WebElement bodyFld;

    @FindBy(xpath = "//div[@role='button' and starts-with(@aria-label,'Send')]")
    private WebElement sendEmailBtn;

    // **** ACTIONS ****

    public ComposeEmailPage sendEmailTo(String receiver, EmailContent content){
        receiverFld.sendKeys(receiver);
        subjectFld.sendKeys(content.subject);
        bodyFld.sendKeys(content.body);
        sendEmailBtn.click();
        return new ComposeEmailPage(driver);
    }
}
