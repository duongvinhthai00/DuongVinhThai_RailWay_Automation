package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    private String txt_email_id = "email";
    private String txt_password_id = "password";
    private String txt_confirmPassword_id = "confirmPassword";
    private String txt_pid_id = "pid";
    private String btn_Register = "//form[@id='RegisterForm']//input[@type='submit']";
    private String lbl_Register_Successfully = "//div[@id='content']/p";
    private static RegisterPage registerPage = null;

    public static RegisterPage getInstance(){
        if(registerPage == null){
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public WebElement getRegisterFieldById(String id){
        return WebDriverManage.getInstance().getWebDriver().findElement(By.id(id));
    }

    public WebElement getFieldEmail(){
        return this.getRegisterFieldById(txt_email_id);
    }

    public WebElement getFieldPassword(){
        return this.getRegisterFieldById(txt_password_id);
    }

    public WebElement getFieldConfirmPassword(){
        return this.getRegisterFieldById(txt_confirmPassword_id);
    }

    public WebElement getFieldPID(){
        return this.getRegisterFieldById(txt_pid_id);
    }

    public WebElement getBtnRegister(){
        return WebDriverManage.getInstance().findElementByXpath(btn_Register);
    }

    public WebElement getLblRegisterSuccess(){
        return WebDriverManage.getInstance().findElementByXpath(lbl_Register_Successfully);
    }

    public String getRegisterSuccessMessage(){
        return this.getLblRegisterSuccess().getText();
    }

    public void Register(String email,String password,String confirmPassword,String pid){
        this.getFieldEmail().sendKeys(email);
        this.getFieldPassword().sendKeys(password);
        this.getFieldConfirmPassword().sendKeys(confirmPassword);
        this.getFieldPID().sendKeys(pid);
        this.getBtnRegister().click();
        System.out.println("Your UserName/Email : " + email);
        System.out.println("Your Password : " + password);
    }
}
