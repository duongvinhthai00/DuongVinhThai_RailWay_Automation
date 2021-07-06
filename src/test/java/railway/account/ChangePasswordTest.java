package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.railway.*;
import railway.TestBase;

public class ChangePasswordTest extends TestBase {

    HomePage homePage = HomePage.getNewInstance();
    GeneralPage generalPage = GeneralPage.getNewInstance();
    LoginPage loginPage = LoginPage.getNewInstance();
    ChangePasswordPage changePasswordPage = ChangePasswordPage.getNewInstance();

    @Test(description = "User can change password")
    public void TC09(){
        homePage.open();
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD,Constant.NEW_PASSWORD);
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(),Constant.CHANGE_PASSWORD_MESSAGE_SUCCESS);
        changePasswordPage.changePassword(Constant.NEW_PASSWORD,Constant.PASSWORD);
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(),Constant.CHANGE_PASSWORD_MESSAGE_SUCCESS);
        if (generalPage.CheckTabLogoutExist()){
            homePage.Logout();
        }
    }
}
