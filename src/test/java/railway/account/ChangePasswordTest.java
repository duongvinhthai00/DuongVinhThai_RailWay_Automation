package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.ChangePasswordPage;
import railway.TestBase;

public class ChangePasswordTest extends TestBase {

    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        if (generalPage.CheckTabLogoutExist()) {
            homePage.Logout();
        }
    }

    @Test(description = "User can change password")
    public void TC09() {
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(Constant.VALID_PASSWORD, Constant.NEW_PASSWORD);
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), Constant.CHANGE_PASSWORD_MESSAGE_SUCCESS);
        changePasswordPage.changePassword(Constant.NEW_PASSWORD, Constant.VALID_PASSWORD);
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), Constant.CHANGE_PASSWORD_MESSAGE_SUCCESS);
    }
}
