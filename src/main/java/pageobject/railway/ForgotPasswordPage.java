package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    private final By fieldEmailAddress = By.id("email");
    private final By btnSendInstructions = By.xpath("//div[@id='content']//input[@type='submit' and @value='Send Instructions']");

    private WebElement getElementEmailAddress() {
        return WebDriverManage.getDriver().findElement(fieldEmailAddress);
    }

    private WebElement getElementSendInstructionsSubmit() {
        return WebDriverManage.getDriver().findElement(btnSendInstructions);
    }

    public void SendRequestResetPassword(String email) {
        WebDriverManage.ScrollTo(this.getElementEmailAddress());
        this.getElementEmailAddress().sendKeys(email);
        WebDriverManage.ScrollTo(this.getElementSendInstructionsSubmit());
        this.getElementSendInstructionsSubmit().click();
    }

}
