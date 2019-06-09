package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Andres on 6/7/2019.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "identifierId")
    private WebElement emailFld;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordFld;

    @FindBy(id = "identifierNext")
    private WebElement loginNextBtn;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextBtn;

    public InboxPage signIn(String emailAccount, String password){
        wait.until(ExpectedConditions.visibilityOf(emailFld));
        emailFld.sendKeys(emailAccount);
        loginNextBtn.click();
        passwordFld.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(passwordNextBtn));
        passwordNextBtn.click();
        return new InboxPage(driver);
    }
}
