package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    private String txt_email_id = "email";
    private String txt_password_id = "password";
    private String txt_confirmPassword_id = "confirmPassword";
    private String txt_pid_id = "pid";
    private String btn_Register = "//form[@id='RegisterForm']//input[@type='submit']";
    private String lbl_Register_Successfully = "//div[@id='content']/p";
    private String lbl_Register_failed = "//div[@id='content']/p[@class='message error']";
    private String lbl_Password_empty_message = "//form[@id='RegisterForm']//li[@class='password']//label[@class='validation-error']";
    private String lbl_Pid_empty_message = "//form[@id='RegisterForm']//li[@class='pid-number']//label[@class='validation-error']";
    private static RegisterPage registerPage = null;

    public static RegisterPage getNewInstance() {
        registerPage = new RegisterPage();
        return registerPage;
    }

    private WebElement getLblPasswordEmpty() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Password_empty_message);
    }

    private WebElement getLblPidEmpty() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Pid_empty_message);
    }

    private WebElement getFieldEmail() {
        return WebDriverManage.getInstance().findElementById(txt_email_id);
    }

    private WebElement getFieldPassword() {
        return WebDriverManage.getInstance().findElementById(txt_password_id);
    }

    private WebElement getFieldConfirmPassword() {
        return WebDriverManage.getInstance().findElementById(txt_confirmPassword_id);
    }

    private WebElement getFieldPID() {
        return WebDriverManage.getInstance().findElementById(txt_pid_id);
    }

    private WebElement getBtnRegister() {
        return WebDriverManage.getInstance().findElementByXpath(btn_Register);
    }

    private WebElement getLblRegisterSuccess() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Register_Successfully);
    }

    private WebElement getLblRegisterFailed() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Register_failed);
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
