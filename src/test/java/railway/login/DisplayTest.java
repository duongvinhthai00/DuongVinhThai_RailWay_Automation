package railway.login;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.*;
import railway.TestBase;

public class DisplayTest extends TestBase {
    @BeforeMethod
    public void beforeMethod() {
        HomePage.getInstance().open();
    }


    @AfterMethod
    public void afterMethod() {
        if (GeneralPage.getInstance().CheckTabLogoutExist()){
            HomePage.getInstance().Logout();
        }
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().login(Constant.USERNAME, Constant.PASSWORD);
        Assert.assertEquals(GeneralPage.getInstance().CheckTabDisplayAfterLogin(), true);
        HomePage.getInstance().goToMyTicketPage();
        Assert.assertEquals(GeneralPage.getInstance().CheckPageOpen("My Ticket"), true);
        HomePage.getInstance().goToChangePasswordPage();
        Assert.assertEquals(GeneralPage.getInstance().CheckPageOpen("Change Password"), true);
        HomePage.getInstance().Logout();
    }

    @Test(description = "User can create new account")
    public void TC07() {
        HomePage.getInstance().goToRegisterPage();
        String email = Constant.EMAIL_RANDOM;
        RegisterPage.getInstance().Register(email,Constant.PASSWORD,Constant.PASSWORD,Constant.PID);
        Assert.assertEquals(RegisterPage.getInstance().getRegisterSuccessMessage(), Constant.REGISTER_MESSAGE_SUCCESS);
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08(){
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().login(Constant.USERNAME,Constant.PASSWORD);
        Assert.assertEquals(LoginPage.getInstance().getLoginErrorMessage(),Constant.INVALID_USERNAME_PASSWORD);
    }

    @Test(description = "User can change password")
    public void TC09(){
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().login(Constant.USERNAME,Constant.PASSWORD);
        HomePage.getInstance().goToChangePasswordPage();
        ChangePasswordPage.getInstance().changePassword(Constant.PASSWORD,Constant.NEW_PASSWORD);
        Assert.assertEquals(ChangePasswordPage.getInstance().getChangePasswordSuccessMessage(),Constant.CHANGE_PASSWORD_MESSAGE_SUCCESS);
    }
}
