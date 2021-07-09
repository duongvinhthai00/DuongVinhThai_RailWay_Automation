package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    private String fieldEmailAddress = "email";
    private String btnSendInstructions = "//div[@id='content']//input[@type='submit' and @value='Send Instructions']";
    private static ForgotPasswordPage forgotPasswordPage = null;

    public static ForgotPasswordPage getNewInstance() {
        forgotPasswordPage = new ForgotPasswordPage();
        return forgotPasswordPage;
    }

    private WebElement getFieldEmailAddress() {
        return WebDriverManage.getInstance().findElementById(fieldEmailAddress);
    }

    private WebElement getBtnSendInstructions() {
        return WebDriverManage.getInstance().findElementByXpath(btnSendInstructions);
    }

    public void SendRequestResetPassword(String email) {
        WebDriverManage.getInstance().ScrollTo(this.getFieldEmailAddress());
        this.getFieldEmailAddress().sendKeys(email);
        WebDriverManage.getInstance().ScrollTo(this.getBtnSendInstructions());
        this.getBtnSendInstructions().click();
    }

}
