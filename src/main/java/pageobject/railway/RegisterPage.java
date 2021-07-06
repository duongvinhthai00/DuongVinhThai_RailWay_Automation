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

    public WebElement getLblPasswordEmpty() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Password_empty_message);
    }

    public WebElement getLblPidEmpty() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Pid_empty_message);
    }

    public WebElement getFieldEmail() {
        return WebDriverManage.getInstance().findElementById(txt_email_id);
    }

    public WebElement getFieldPassword() {
        return WebDriverManage.getInstance().findElementById(txt_password_id);
    }

    public WebElement getFieldConfirmPassword() {
        return WebDriverManage.getInstance().findElementById(txt_confirmPassword_id);
    }

    public WebElement getFieldPID() {
        return WebDriverManage.getInstance().findElementById(txt_pid_id);
    }

    public WebElement getBtnRegister() {
        return WebDriverManage.getInstance().findElementByXpath(btn_Register);
    }

    public WebElement getLblRegisterSuccess() {
        return WebDriverManage.getInstance().findElementByXpath(lbl_Register_Successfully);
    }

    public WebElement getLblRegisterFailed() {
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
        this.getFieldEmail().sendKeys(email);
        this.getFieldPassword().sendKeys(password);
        this.getFieldConfirmPassword().sendKeys(confirmPassword);
        this.getFieldPID().sendKeys(pid);
        this.getBtnRegister().click();
        System.out.println("Your UserName/Email : " + email);
        System.out.println("Your Password : " + password);
    }
}
