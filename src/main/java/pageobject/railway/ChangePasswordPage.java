package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    private By lblChangePasswordSuccess = By.xpath("//form[@id='ChangePW']//p[@class='message success']");
    private By btnChangePassword = By.xpath("//form[@id='ChangePW']//input[@type='submit']");
    private static ChangePasswordPage changePasswordPage = null;

    private WebElement getChangePasswordFieldById(String id){
        return WebDriverManage.getInstance().getDriver().findElement(By.id(id));
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
        return WebDriverManage.getInstance().getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblChangePasswordSuccess(){
        return WebDriverManage.getInstance().getDriver().findElement(lblChangePasswordSuccess);
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
