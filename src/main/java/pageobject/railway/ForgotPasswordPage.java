package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    private By fieldEmailAddress = By.id("email");
    private By btnSendInstructions = By.xpath("//div[@id='content']//input[@type='submit' and @value='Send Instructions']");
    private static ForgotPasswordPage forgotPasswordPage = null;

    private WebElement getFieldEmailAddress() {
        return WebDriverManage.getInstance().getDriver().findElement(fieldEmailAddress);
    }

    private WebElement getBtnSendInstructions() {
        return WebDriverManage.getInstance().getDriver().findElement(btnSendInstructions);
    }

    public void SendRequestResetPassword(String email) {
        WebDriverManage.getInstance().ScrollTo(this.getFieldEmailAddress());
        this.getFieldEmailAddress().sendKeys(email);
        WebDriverManage.getInstance().ScrollTo(this.getBtnSendInstructions());
        this.getBtnSendInstructions().click();
    }

}
