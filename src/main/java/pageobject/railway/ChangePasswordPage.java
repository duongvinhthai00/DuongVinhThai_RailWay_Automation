package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    private final By lblChangePasswordSuccess = By.xpath("//form[@id='ChangePW']//p[@class='message success']");
    private final By fieldCurrentPassword = By.id("currentPassword");
    private final By fieldNewPassword = By.id("newPassword");
    private final By fieldConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//form[@id='ChangePW']//input[@type='submit']");

    private WebElement getElementCurrentPassword() {
        return WebDriverManage.getDriver().findElement(fieldCurrentPassword);
    }

    private WebElement getElementNewPassword() {
        return WebDriverManage.getDriver().findElement(fieldNewPassword);
    }

    private WebElement getElementConfirmPassword() {
        return WebDriverManage.getDriver().findElement(fieldConfirmPassword);
    }

    private WebElement getElementChangePasswordSubmit() {
        return WebDriverManage.getDriver().findElement(btnChangePassword);
    }

    private WebElement getElementChangePasswordSuccess() {
        return WebDriverManage.getDriver().findElement(lblChangePasswordSuccess);
    }

    public String getChangePasswordSuccessMessage() {
        return this.getElementChangePasswordSuccess().getText();
    }

    public void changePassword(String password, String newPassword) {
        WebDriverManage.ScrollTo(this.getElementCurrentPassword());
        this.getElementCurrentPassword().sendKeys(password);
        WebDriverManage.ScrollTo(this.getElementNewPassword());
        this.getElementNewPassword().sendKeys(newPassword);
        WebDriverManage.ScrollTo(this.getElementConfirmPassword());
        this.getElementConfirmPassword().sendKeys(newPassword);
        WebDriverManage.ScrollTo(this.getElementChangePasswordSubmit());
        this.getElementChangePasswordSubmit().click();
    }
}
