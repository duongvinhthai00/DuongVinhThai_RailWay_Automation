package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    private String fieldEmailAddress = "email";
    private String btnSendInstructions = "//div[@id='content']//input[@type='submit' and @value='Send Instructions']";
    private static ForgotPasswordPage forgotPasswordPage = null;
    private String lblMailBoxTitle = "//span[text()='reset password link']";

    public static ForgotPasswordPage getNewInstance() {
        forgotPasswordPage = new ForgotPasswordPage();
        return forgotPasswordPage;
    }

    public WebElement getLblMailBoxTitle(){
        return WebDriverManage.getInstance().findElementByXpath(lblMailBoxTitle);
    }

    public WebElement getFieldEmailAddress(){
        return WebDriverManage.getInstance().findElementById(fieldEmailAddress);
    }

    public WebElement getBtnSendInstructions(){
        return WebDriverManage.getInstance().findElementByXpath(btnSendInstructions);
    }

    public void SendRequestResetPassword(String email){
        this.getFieldEmailAddress().sendKeys(email);
        this.getBtnSendInstructions().click();
    }

    public void ClickLink(){
        this.getLblMailBoxTitle().click();
    }
}
