package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    private String lblChangePasswordSuccess = "//form[@id='ChangePW']//p[@class='message success']";
    private String btnChangePassword = "//form[@id='ChangePW']//input[@type='submit']";
    private static ChangePasswordPage changePasswordPage = null;

    public static ChangePasswordPage getNewInstance(){
        changePasswordPage = new ChangePasswordPage();
        return changePasswordPage;
    }

    private WebElement getChangePasswordFieldById(String id){
        return WebDriverManage.getInstance().getWebDriver().findElement(By.id(id));
    }

    private WebElement getFieldCurrentPassword(){
        return getChangePasswordFieldById("currentPassword");
    }

    private WebElement getFieldNewPassword(){
        return getChangePasswordFieldById("newPassword");
    }

    private WebElement getFieldConfirmPassword(){
        return getChangePasswordFieldById("confirmPassword");
    }

    private WebElement getBtnChangePassword(){
        return WebDriverManage.getInstance().findElementByXpath(btnChangePassword);
    }

    private WebElement getLblChangePasswordSuccess(){
        return WebDriverManage.getInstance().findElementByXpath(lblChangePasswordSuccess);
    }

    public String getChangePasswordSuccessMessage(){
        return this.getLblChangePasswordSuccess().getText();
    }

    public void changePassword(String password,String newPassword){
        WebDriverManage.getInstance().ScrollTo(this.getFieldCurrentPassword());
        this.getFieldCurrentPassword().sendKeys(password);
        WebDriverManage.getInstance().ScrollTo(this.getFieldNewPassword());
        this.getFieldNewPassword().sendKeys(newPassword);
        WebDriverManage.getInstance().ScrollTo(this.getFieldConfirmPassword());
        this.getFieldConfirmPassword().sendKeys(newPassword);
        WebDriverManage.getInstance().ScrollTo(this.getBtnChangePassword());
        this.getBtnChangePassword().click();
    }
}
