package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    private final By fieldEmail = By.id("email");
    private final By fieldPassword = By.id("password");
    private final By fieldConfirmPassword = By.id("confirmPassword");
    private final By fieldPid = By.id("pid");
    private final By btnRegister = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    private final By lblRegisterSuccessfully = By.xpath("//div[@id='content']/p");
    private final By lblRegisterFailed = By.xpath("//div[@id='content']/p[@class='message error']");
    private final By lblPasswordEmptyMessage = By.xpath("//form[@id='RegisterForm']//li[@class='password']//label[@class='validation-error']");
    private final By lblPidEmptyMessage = By.xpath("//form[@id='RegisterForm']//li[@class='pid-number']//label[@class='validation-error']");

    private WebElement getElementPasswordEmpty() {
        return WebDriverManage.getDriver().findElement(lblPasswordEmptyMessage);
    }

    private WebElement getElementPidEmpty() {
        return WebDriverManage.getDriver().findElement(lblPidEmptyMessage);
    }

    private WebElement getElementEmail() {
        return WebDriverManage.getDriver().findElement(fieldEmail);
    }

    private WebElement getElementPassword() {
        return WebDriverManage.getDriver().findElement(fieldPassword);
    }

    private WebElement getElementConfirmPassword() {
        return WebDriverManage.getDriver().findElement(fieldConfirmPassword);
    }

    private WebElement getElementPID() {
        return WebDriverManage.getDriver().findElement(fieldPid);
    }

    private WebElement getBtnRegister() {
        return WebDriverManage.getDriver().findElement(btnRegister);
    }

    private WebElement getElementRegisterSuccess() {
        return WebDriverManage.getDriver().findElement(lblRegisterSuccessfully);
    }

    private WebElement getElementRegisterFailed() {
        return WebDriverManage.getDriver().findElement(lblRegisterFailed);
    }

    public String getRegisterSuccessMessage() {
        return this.getElementRegisterSuccess().getText();
    }

    public String getRegisterFailedMessage() {
        return this.getElementRegisterFailed().getText();
    }

    public String getPasswordEmptyMessage() {
        return this.getElementPasswordEmpty().getText();
    }

    public String getPidEmptyMessage() {
        return this.getElementPidEmpty().getText();
    }

    public void Register(String email, String password, String confirmPassword, String pid) {
        WebDriverManage.ScrollTo(this.getElementEmail());
        this.getElementEmail().sendKeys(email);
        WebDriverManage.ScrollTo(this.getElementPassword());
        this.getElementPassword().sendKeys(password);
        WebDriverManage.ScrollTo(this.getElementConfirmPassword());
        this.getElementConfirmPassword().sendKeys(confirmPassword);
        WebDriverManage.ScrollTo(this.getElementPID());
        this.getElementPID().sendKeys(pid);
        WebDriverManage.ScrollTo(this.getBtnRegister());
        this.getBtnRegister().click();
    }
}
