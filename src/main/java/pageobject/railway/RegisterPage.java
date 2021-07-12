package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    private By txt_email_id = By.id("email");
    private By txt_password_id = By.id("password");
    private By txt_confirmPassword_id = By.id("confirmPassword");
    private By txt_pid_id = By.id("pid");
    private By btn_Register = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    private By lbl_Register_Successfully = By.xpath("//div[@id='content']/p");
    private By lbl_Register_failed = By.xpath("//div[@id='content']/p[@class='message error']");
    private By lbl_Password_empty_message = By.xpath("//form[@id='RegisterForm']//li[@class='password']//label[@class='validation-error']");
    private By lbl_Pid_empty_message = By.xpath("//form[@id='RegisterForm']//li[@class='pid-number']//label[@class='validation-error']");
    private static RegisterPage registerPage = null;

    private WebElement getLblPasswordEmpty() {
        return WebDriverManage.getInstance().getDriver().findElement(lbl_Password_empty_message);
    }

    private WebElement getLblPidEmpty() {
        return WebDriverManage.getInstance().getDriver().findElement(lbl_Pid_empty_message);
    }

    private WebElement getFieldEmail() {
        return WebDriverManage.getInstance().getDriver().findElement(txt_email_id);
    }

    private WebElement getFieldPassword() {
        return WebDriverManage.getInstance().getDriver().findElement(txt_password_id);
    }

    private WebElement getFieldConfirmPassword() {
        return WebDriverManage.getInstance().getDriver().findElement(txt_confirmPassword_id);
    }

    private WebElement getFieldPID() {
        return WebDriverManage.getInstance().getDriver().findElement(txt_pid_id);
    }

    private WebElement getBtnRegister() {
        return WebDriverManage.getInstance().getDriver().findElement(btn_Register);
    }

    private WebElement getLblRegisterSuccess() {
        return WebDriverManage.getInstance().getDriver().findElement(lbl_Register_Successfully);
    }

    private WebElement getLblRegisterFailed() {
        return WebDriverManage.getInstance().getDriver().findElement(lbl_Register_failed);
    }

    public String getRegisterSuccessMessage() {
        return this.getLblRegisterSuccess().getText();
    }

    public String getRegisterFailedMessage() {
        return this.getLblRegisterFailed().getText();
    }

    public String getPasswordEmptyMessage() {
        return this.getLblPasswordEmpty().getText();
    }

    public String getPidEmptyMessage() {
        return this.getLblPidEmpty().getText();
    }

    public void Register(String email, String password, String confirmPassword, String pid) {
        WebDriverManage.getInstance().ScrollTo(this.getFieldEmail());
        this.getFieldEmail().sendKeys(email);
        WebDriverManage.getInstance().ScrollTo(this.getFieldPassword());
        this.getFieldPassword().sendKeys(password);
        WebDriverManage.getInstance().ScrollTo(this.getFieldConfirmPassword());
        this.getFieldConfirmPassword().sendKeys(confirmPassword);
        WebDriverManage.getInstance().ScrollTo(this.getFieldPID());
        this.getFieldPID().sendKeys(pid);
        WebDriverManage.getInstance().ScrollTo(this.getBtnRegister());
        this.getBtnRegister().click();
        System.out.println("Your UserName/Email : " + email);
        System.out.println("Your Password : " + password);
    }
}
