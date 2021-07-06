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

    public WebElement getChangePasswordFieldById(String id){
        return WebDriverManage.getInstance().getWebDriver().findElement(By.id(id));
    }

    public WebElement getFieldCurrentPassword(){
        return getChangePasswordFieldById("currentPassword");
    }

    public WebElement getFieldNewPassword(){
        return getChangePasswordFieldById("newPassword");
    }

    public WebElement getFieldConfirmPassword(){
        return getChangePasswordFieldById("confirmPassword");
    }

    public WebElement getBtnChangePassword(){
        return WebDriverManage.getInstance().findElementByXpath(btnChangePassword);
    }

    public WebElement getLblChangePasswordSuccess(){
        return WebDriverManage.getInstance().findElementByXpath(lblChangePasswordSuccess);
    }

    public String getChangePasswordSuccessMessage(){
        return this.getLblChangePasswordSuccess().getText();
    }

    public void changePassword(String password,String newPassword){
        this.getFieldCurrentPassword().sendKeys(password);
        this.getFieldNewPassword().sendKeys(newPassword);
        this.getFieldConfirmPassword().sendKeys(newPassword);
        this.getBtnChangePassword().click();
    }
}
