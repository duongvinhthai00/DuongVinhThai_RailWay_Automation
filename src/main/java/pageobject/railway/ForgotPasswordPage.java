package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    private By fieldEmailAddress = By.id("email");
    private By btnSendInstructions = By.xpath("//div[@id='content']//input[@type='submit' and @value='Send Instructions']");
    private static ForgotPasswordPage forgotPasswordPage = null;

    private WebElement getFieldEmailAddress() {
        return WebDriverManage.getDriver().findElement(fieldEmailAddress);
    }

    private WebElement getBtnSendInstructions() {
        return WebDriverManage.getDriver().findElement(btnSendInstructions);
    }

    public void SendRequestResetPassword(String email) {
        WebDriverManage.ScrollTo(this.getFieldEmailAddress());
        this.getFieldEmailAddress().sendKeys(email);
        WebDriverManage.ScrollTo(this.getBtnSendInstructions());
        this.getBtnSendInstructions().click();
    }

}
